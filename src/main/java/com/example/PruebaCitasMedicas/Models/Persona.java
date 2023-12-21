package com.example.PruebaCitasMedicas.Models;

public abstract class Persona {
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPatenno() {
        return ApellidoPatenno;
    }

    public void setApellidoPatenno(String apellidoPatenno) {
        ApellidoPatenno = apellidoPatenno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    private String ApellidoPatenno;
    private String ApellidoMaterno;

    public Persona(){

    };
    public Persona(String Nombre, String ApellidoPaterno,String ApellidoMaterno){
        this.Nombre=Nombre;
        this.ApellidoMaterno=ApellidoMaterno;
        this.ApellidoPatenno=ApellidoPaterno;
    };


}
