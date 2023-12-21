package com.example.PruebaCitasMedicas.Services;


import com.example.PruebaCitasMedicas.Models.Medico;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Repository
@Service
public class MedicoService {

    private final JdbcTemplate jdbc;


    public MedicoService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Medico getMedico(int idmedico){
        String sql= "Select * From doctores where idDoctor=? ";
        Map<String, Object> consultaMedico=jdbc.queryForMap(sql,idmedico);
        Medico med=new Medico();
        med.setIdMedico(idmedico);
        med.setNombre((String) consultaMedico.get("Nombre"));
        med.setApellidoPatenno((String) consultaMedico.get("Apellido_Paterno"));
        med.setApellidoMaterno((String) consultaMedico.get("Apellido_Materno"));
        med.setEspecialidad((String) consultaMedico.get("Especialidad"));
        return med;
    }
}
