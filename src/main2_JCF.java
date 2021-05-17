import java.util.PriorityQueue;
import java.util.Scanner;

public class main2_JCF {
    public static void main(String[] args) {
        PriorityQueue<Paciente> cola = new PriorityQueue<>();
        Lector lector = new Lector();
        lector.Lectura();
        Scanner sc = new Scanner(System.in);
        String opc;
        boolean salir = false;
        cola.addAll(lector.getAllPacientes());
        while (!salir) {
            while (true) {
                System.out.println("Bienvenido al programa de atención de pacientes\n¿Qué desea hacer?");
                System.out.println("\t1. Ver la cola actual\n" +
                        "\t2. Agregar paciente\n" +
                        "\t3. Reiniciar cola \n" +
                        "\t4. Atender paciente \n" +
                        "\t5. Salir \n");
                System.out.println("Ingrese indice...");
                opc = sc.nextLine();
                if (opc.equals("1") || opc.equals("2") || opc.equals("3") || opc.equals("4") || opc.equals("5")) break;
                else System.out.println("Indice no valido");
            }
            switch (opc) {
                case "1": {
                    //Muestra al cola
                    System.out.println(cola.toString());
                    break;
                }
                case "2": {
                    String nombreNuevo = "";
                    String prioridad = "";
                    String condicion = "";
                    System.out.println("Ingrese el nombre del paciente");
                    nombreNuevo = sc.nextLine();
                    System.out.println("Ingrese la condicion del paciente");
                    condicion = sc.nextLine();
                    while (true) {
                        System.out.println("Ingrese la priorida del paciente (letra de A a la E, en mayuscula)");
                        prioridad = sc.nextLine();
                        if (prioridad.equals("A") || prioridad.equals("B") || prioridad.equals("C") || prioridad.equals("D") || prioridad.equals("E"))
                            break;
                        else System.out.println("Prioridad no valida");
                    }
                    Paciente newPaciente = new Paciente(nombreNuevo, condicion, prioridad);
                    //MiCola.add(newPaciente);
                    break;
                }

                case "3": {
                    cola.clear();
                    cola.addAll(lector.getAllPacientes());
                    System.out.println("Cola reiniciada a los pacientes descritos en el archivo de texto plano\n Todos los pacientes agregados fueron eliminados");
                    break;
                }
                case "4": {
                    cola.poll();
                    break;
                }
                case "5": {
                    System.out.println("Adios!");
                    salir = true;
                    break;
                }
            }
        }


    }
}
