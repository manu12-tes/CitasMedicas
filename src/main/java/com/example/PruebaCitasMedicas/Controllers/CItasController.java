package com.example.PruebaCitasMedicas.Controllers;

import com.example.PruebaCitasMedicas.Models.CItas;
import com.example.PruebaCitasMedicas.Services.CitasService;
import com.example.PruebaCitasMedicas.Services.ConsultorioService;
import com.example.PruebaCitasMedicas.Services.MedicoService;
import com.example.PruebaCitasMedicas.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


@RestController
@Configuration
public class CItasController {

    @Autowired
    public CitasService citasService;
    @Autowired
    public MedicoService medicoService;
    @Autowired
    public PacienteService pacienteServiceService;
    @Autowired
    public ConsultorioService consultorioServiceService;

    @GetMapping("/listaCitas")
    public ResponseEntity<List<Map<String,Object>>> getListaDeCitas(){
        try {
            return ResponseEntity.ok(citasService.listaCitas());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @GetMapping("/CitasByFecha/{fecha}")
    public ResponseEntity<List<Map<String,Object>>> getCitasByFecha(@PathVariable Date fecha){
        try {
            return ResponseEntity.ok(citasService.getCytasByfecha(fecha));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @GetMapping("/CitasByDoctor/{idDoctor}")
    public ResponseEntity<List<Map<String,Object>>> getCitasByDoctor(@PathVariable int idDoctor){
        try {
            return ResponseEntity.ok(citasService.getCytasByDoctor(idDoctor));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @GetMapping("/CitasByConsultorio/{idConsultorio}")
    public ResponseEntity<List<Map<String,Object>>> getCitasByConsultorio(@PathVariable int idConsultorio){
        try {
            return ResponseEntity.ok(citasService.getCytasByConsultorio(idConsultorio));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @PostMapping("/addCita")
    public ResponseEntity<Boolean> agregarCita (
            @RequestParam int idMedico,
            @RequestParam int idConsultorio,
            @RequestParam int idPaciente,
            @RequestParam Date fecha,
            @RequestParam LocalDateTime hora_inicio,
            @RequestParam LocalDateTime hora_fin
            ){
        try{
            return ResponseEntity.ok(citasService.SaveCitasMedicas(new CItas(
                    medicoService.getMedico(idMedico),
                    consultorioServiceService.getConsultorio(idConsultorio),
                    pacienteServiceService.getPaciente(idPaciente),
                    hora_inicio,
                    hora_fin,
                    fecha,
                    0
            )));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PostMapping("/editCita")
    public ResponseEntity<Boolean> EditaCita (
            @RequestParam int idCita
    ){
        try{
            return ResponseEntity.ok(citasService.editCitaMedica(citasService.getCita(idCita)));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping("/deleteCita/{idCita}")
    public ResponseEntity<Boolean> deleteCita(@PathVariable int idCita){
        try{
            return  ResponseEntity.ok(citasService.deleteCItasMedicas(idCita));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(false);
        }
    }

}
