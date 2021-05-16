public class Paciente implements Comparable<Paciente>{
    private String prioridad;
    private int numPriority;
    private String nombre;
    private String condicionOEnfermedad;
    public int posicionEnCola;
    public Paciente(String nombre, String condicionOEnfermedad, String prioridad){
        this.prioridad=prioridad;
        this.nombre=nombre;
        this.condicionOEnfermedad=condicionOEnfermedad;
        if(prioridad.equals("A")||prioridad.equals("B")||prioridad.equals("C")||prioridad.equals("D")||prioridad.equals("E")){
            numPriority=
                    prioridad.equals("A")?1:
                            prioridad.equals("B")?2:
                                    prioridad.equals("C")?3:
                                            prioridad.equals("D")?4:5;
        }else System.out.println("Error con la prioridad de paciente ingresada");
    }

    @Override
    //Return 1, si es mayor al otroPaciente, 0 si es menor o igual
    public int compareTo(Paciente otroPaciente) {
        return (numPriority>otroPaciente.getNumPriority())?1:-1;
    }
    public String toString(){
        return "Nombre: "+nombre+"\nPrioridad: "+prioridad+"("+numPriority+")\nCondicion:  "+condicionOEnfermedad;
    }
    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getNumPriority() {
        return numPriority;
    }

    public void setNumPriority(int numPriority) {
        this.numPriority = numPriority;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondicionOEnfermedad() {
        return condicionOEnfermedad;
    }

    public void setCondicionOEnfermedad(String condicionOEnfermedad) {
        this.condicionOEnfermedad = condicionOEnfermedad;
    }
}
