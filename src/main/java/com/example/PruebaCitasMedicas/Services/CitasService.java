package com.example.PruebaCitasMedicas.Services;

import com.example.PruebaCitasMedicas.Models.CItas;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Service
public class CitasService {

    private final JdbcTemplate jdbc;
    public MedicoService med;
    public PacienteService pac;

    public ConsultorioService con;

    public CitasService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Boolean exisxtCita(CItas cita){

        String sql="Select * From Citas where idPaciente=? and idMedico=? and Hora_Inicio=? and Hora_fin=?";
        return false;
    }

    public List<Map<String, Object>> listaCitas (){
        String sql="Select* from citas";
        List<Map<String, Object>> lista=jdbc.queryForList(sql);
        return lista;
    }
    public CItas getCita (int idCita){
        String sql="Select * from citas where idCita=?";
        Map<String,Object> cita=jdbc.queryForMap(sql, idCita);
        CItas c=new CItas();
        c.setIdCita(idCita);
        c.setMedico(med.getMedico((int) cita.get("idDoctor")));
        c.setPaciente(pac.getPaciente((int) cita.get("idPaciente")));
        c.setConsultorio(con.getConsultorio((int) cita.get("idCOnsultorio")));
        c.setDate((Date) cita.get("fecha"));
        c.setHoraFin((LocalDateTime) cita.get("Hora_fin"));
        c.setHoraInicio((LocalDateTime) cita.get(("Hora_Inicio")));
        return c;
    }

    public List<Map<String,Object>> getCytasByfecha(Date date){
        String sql ="Select * From Citas where fecha=?;";
        List<Map<String, Object>> lista =jdbc.queryForList(sql,date);
        return lista;
    }

    public List<Map<String,Object>> getCytasByConsultorio(int idConsultorio){
        String sql ="Select * From Citas where idConsultorio=?;";
        List<Map<String, Object>> lista =jdbc.queryForList(sql,idConsultorio);
        return lista;
    }

    public List<Map<String ,Object>> getCytasByDoctor(int idDoctor){
        String sql ="Select * From Citas where idConsultorio=?;";
        List<Map<String, Object>> lista =jdbc.queryForList(sql,idDoctor);
        return lista;
    }

    public Boolean SaveCitasMedicas(CItas cItas){

        String sql= "insert into Citas (idDoctor,idConsultorio,idPaciente, fecha, Hora_inicio,Hora_fin) "
                +" values (?,?,?,?,?,?);";
        return jdbc.update(sql,
                cItas.getMedico().getIdMedico(),
                cItas.getConsultorio().getIdConsultorio(),
                cItas.getPaciente().getIdPaciente(),
                cItas.getDate(),
                cItas.getHoraInicio(),
                cItas.getHoraFin()
                )==1;
    }

    public Boolean editCitaMedica(CItas citas){

        String sql="Update Citas " +
                "Set idMedico=?,"+
                "Set idConsultorio=?,"+
                "Set idPaciente=?,"+
                "Set idFecha=?,"+
                "Set Hora_Inicio=?,"+
                "Set Hora_fin=?,"+
                "where idCita=?,";
        return jdbc.update(sql,
                citas.getMedico().getIdMedico(),
                citas.getConsultorio().getIdConsultorio(),
                citas.getPaciente().getIdPaciente(),
                citas.getDate(),
                citas.getHoraInicio(),
                citas.getHoraFin()
        )==1;
    }

    public Boolean deleteCItasMedicas(int idCita){
        String sql="delete from citas where idCita=?";
        return jdbc.update(sql,idCita)==1;
    }

}
