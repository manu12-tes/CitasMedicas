package com.example.PruebaCitasMedicas.Models;

import java.time.LocalDateTime;
import java.util.Date;

public class CItas {

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        HoraInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        HoraFin = horaFin;
    }

    private Medico medico;
    private Consultorio consultorio;
    private Paciente paciente;

    private LocalDateTime HoraInicio;
    private LocalDateTime HoraFin;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    private int idCita;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;




    public CItas(){

    }

    public CItas(Medico medico, Consultorio consultorio, Paciente paciente, LocalDateTime horaInicio, LocalDateTime horaFin, Date date, int idCita) {
        this.medico = medico;
        this.consultorio = consultorio;
        this.paciente = paciente;
        HoraInicio = horaInicio;
        HoraFin = horaFin;
        this.date=date;
        this.idCita=idCita;
    }
}
