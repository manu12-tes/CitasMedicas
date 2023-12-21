package com.example.PruebaCitasMedicas.Services;

import com.example.PruebaCitasMedicas.Models.Consultorio;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.Objects;

public class ConsultorioService {
    private final JdbcTemplate jdbc;
    public ConsultorioService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Consultorio getConsultorio(int idConsultorio){
        String sql="Select* from conultorio where idCOnsultorio=?;";
        Map<String, Object> consulta=jdbc.queryForMap(sql, idConsultorio);
        Consultorio c=new Consultorio();
        c.setIdConsultorio(idConsultorio);
        c.setPiso((int) consulta.get("piso"));
        return c;
    }

}
