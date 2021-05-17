public class Paciente implements Comparable<Paciente> {
    public String prioridad;
    public int numPriority;
    public String nombre;
    public String condicionOEnfermedad;
    public int posicionEnCola;

    /**
     * @param nombre               ingresa el nomobre del paciente
     * @param condicionOEnfermedad ingresa la condicion del paciente
     * @param prioridad            ingresa la priodida de su caso
     */
    public Paciente(String nombre, String condicionOEnfermedad, String prioridad) {
        this.prioridad = prioridad;
        this.nombre = nombre;
        this.condicionOEnfermedad = condicionOEnfermedad;
        if (prioridad.equals("A") || prioridad.equals("B") || prioridad.equals("C") || prioridad.equals("D") || prioridad.equals("E")) {
            numPriority =
                    prioridad.equals("A") ? 1 :
                            prioridad.equals("B") ? 2 :
                                    prioridad.equals("C") ? 3 :
                                            prioridad.equals("D") ? 4 : 5;
        } else System.out.println("Error con la prioridad de paciente ingresada");
    }

    @Override
    /**
     * Return 1, si es mayor al otroPaciente, 0 si es igual, -1 si es menor
     */
    public int compareTo(Paciente otroPaciente) {
        return Integer.compare(numPriority, otroPaciente.getNumPriority());
    }

    /**
     * @return devuelve los datos importantes del paciente
     */
    public String toString() {
        return "\nNombre: " + nombre + "\nPrioridad: " + prioridad + "(" + numPriority + ")\nCondicion:  " + condicionOEnfermedad;
    }

    /**
     * @return devuelve el numero de prioridad del paciente
     */
    public int getNumPriority() {
        return numPriority;
    }

}
