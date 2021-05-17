import java.io.*;
import java.util.*;

public class Lector {
    private Vector<Paciente> allPacientes;

    /**
     * @return devuelve el vector de pacienttes obtenidas de la lectura del archivo de texto plano
     */
    public Vector<Paciente> getAllPacientes() {
        return allPacientes;
    }

    /**
     * Realiza la lectura del texto plano
     */
    public void Lectura() {
        allPacientes = new Vector<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String salida = "";

        try {
            archivo = new File("assets/pacientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String bfRead;
            while ((bfRead = br.readLine()) != null) {
                String separador = ",";
                String[] linea = bfRead.split(separador);
                allPacientes.add(new Paciente(linea[0].trim(), linea[1].trim(), linea[2].trim()));
            }
        } catch (Exception e) {
            salida = e.toString();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                salida = e2.toString();
            }
        }
    }

}
