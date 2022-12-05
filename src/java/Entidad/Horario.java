package Entidad;

import java.util.List;

public class Horario {
    private int IDHorario;
    private int IDTurno;
    private String Nombre;
    public List<Turno> lstTurno;
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
     * @return the IDTurno
     */
    public int getIDTurno() {
        return IDTurno;
    }

    /**
     * @param IDTurno the IDTurno to set
     */
    public void setIDTurno(int IDTurno) {
        this.IDTurno = IDTurno;
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
}
