
package Entidad;

public class Doctor {
    private int IDDoctor;
    private int IDHorario;
    private int IDEspecialidad;
    private String Nombre;
    private String Telefono;

    /**
     * @return the IDDoctor
     */
    public int getIDDoctor() {
        return IDDoctor;
    }

    /**
     * @param IDDoctor the IDDoctor to set
     */
    public void setIDDoctor(int IDDoctor) {
        this.IDDoctor = IDDoctor;
    }

    /**
     * @return the IDHorario
     */
    public int getIDHorario() {
        return IDHorario;
    }

    /**
     * @param IDHorario the IDHorario to set
     */
    public void setIDHorario(int IDHorario) {
        this.IDHorario = IDHorario;
    }

    /**
     * @return the IDEspecialidad
     */
    public int getIDEspecialidad() {
        return IDEspecialidad;
    }

    /**
     * @param IDEspecialidad the IDEspecialidad to set
     */
    public void setIDEspecialidad(int IDEspecialidad) {
        this.IDEspecialidad = IDEspecialidad;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
}
