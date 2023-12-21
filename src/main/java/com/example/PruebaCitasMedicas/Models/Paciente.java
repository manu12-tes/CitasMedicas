package com.example.PruebaCitasMedicas.Models;

public class Paciente extends Persona {

    public Paciente(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int idPaciente) {
        super(Nombre, ApellidoPaterno, ApellidoMaterno);
        this.idPaciente = idPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    private int idPaciente;
    public Paciente(){

    }
}
