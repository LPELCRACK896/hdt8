import java.io.*;
import java.util.*;
public class Lector {
    public ArrayList<Paciente> allPacientes;
    public void Lectura(){
        ArrayList<Paciente> allPacientes= new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String salida = "";

        try {
            archivo = new File("assets/pacientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String bfRead;
            while((bfRead = br.readLine() )!= null) {
                String separador = ",";
                String[] linea = bfRead.split(separador);
                System.out.println(linea[2]);
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
