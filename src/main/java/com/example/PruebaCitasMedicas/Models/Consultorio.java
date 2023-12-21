package com.example.PruebaCitasMedicas.Models;

public class Consultorio {

    public int getPiso() {
        return piso;
    }


    public void setPiso(int piso) {
        this.piso = piso;
    }

    private int piso;

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    private int idConsultorio;

    public Consultorio(){

    };
    public Consultorio(int piso){
        this.piso=piso;
    }
}
