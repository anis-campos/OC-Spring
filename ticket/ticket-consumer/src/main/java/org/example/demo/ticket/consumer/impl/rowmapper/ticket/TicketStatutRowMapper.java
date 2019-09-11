package org.example.demo.ticket.consumer.impl.rowmapper.ticket;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketStatutRowMapper implements RowMapper<TicketStatut> {

    @Override
    public TicketStatut mapRow(ResultSet rs, int i) throws SQLException {
        TicketStatut s = new TicketStatut();
        s.setId(rs.getInt("statut_id"));
        s.setLibelle(rs.getString("statut_libelle"));
        return s;
    }
}
