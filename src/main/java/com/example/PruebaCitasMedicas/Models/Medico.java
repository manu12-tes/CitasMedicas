package com.example.PruebaCitasMedicas.Models;

public class Medico extends  Persona{

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    String Especialidad;

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    int idMedico;
    public Medico(){

    }

    public Medico(String Nombre, String ApellidoPaterno,String ApellidoMaterno, String Especialidad, int idMedico){
        super(Nombre,ApellidoPaterno,ApellidoMaterno);
        this.Especialidad=Especialidad;
        this.idMedico=idMedico;
    }
}
