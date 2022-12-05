
package Entidad;

public class Cita {
    private int IDCita;
    private int IDDoctor;
    private int IDPaciente;
    private int IDHorario;
    private String Fecha;
    private String Diagnostico;
    private String Tratamiento;
    private String Observaciones;

    public int getIDCita() {
        return IDCita;
    }

    public void setIDCita(int IDCita) {
        this.IDCita = IDCita;
    }

    public int getIDDoctor() {
        return IDDoctor;
    }

    public void setIDDoctor(int IDDoctor) {
        this.IDDoctor = IDDoctor;
    }

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    public int getIDHorario() {
        return IDHorario;
    }

    public void setIDHorario(int IDHorario) {
        this.IDHorario = IDHorario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    
}
