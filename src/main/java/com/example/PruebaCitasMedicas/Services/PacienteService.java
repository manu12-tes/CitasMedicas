package com.example.PruebaCitasMedicas.Services;


import com.example.PruebaCitasMedicas.Models.Paciente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Repository
@Service
public class PacienteService {
    private final JdbcTemplate jdbc;

    public PacienteService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Paciente getPaciente(int idPaciente){
        String sql =" Select * From pacientes where idPaciente=?";
        Map<String, Object>consultaPaciente=jdbc.queryForMap(sql, idPaciente);
        Paciente p=new Paciente();
        p.setIdPaciente(idPaciente);
        p.setNombre((String) consultaPaciente.get("Nombre"));
        p.setApellidoPatenno((String) consultaPaciente.get("Apellido_Paterno"));
        p.setApellidoMaterno((String) consultaPaciente.get("Apellido_Materno"));
        return p;
    }
}
