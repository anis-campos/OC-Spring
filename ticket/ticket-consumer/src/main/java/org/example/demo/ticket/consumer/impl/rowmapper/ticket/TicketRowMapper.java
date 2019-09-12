package org.example.demo.ticket.consumer.impl.rowmapper.ticket;

import org.apache.commons.lang3.NotImplementedException;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    @Autowired
    private RowMapper<TicketStatut> ticketStatutRowMapper;

    @Autowired
    private RowMapper<BugNiveau> bugNiveauRowMapper;

    @Autowired
    private RowMapper<Projet> projetRowMapper;

    @Override
    public Ticket mapRow(ResultSet rs, int i) throws SQLException {
        Ticket t;

        if (rs.getInt("bug_id") != 0) {
            Bug b = new Bug();
            b.setNiveau(bugNiveauRowMapper.mapRow(rs, i));

            t = b;
        } else if (rs.getInt("evolution_id") != 0) {
            Evolution e = new Evolution();
            e.setPriorite(rs.getInt("evolution_priorite"));
            t = e;
        } else {
            throw new NotImplementedException("This ticket type is not implemented yet");
        }

        t.setNumero(rs.getLong("numero"));
        t.setTitre(rs.getString("titre"));
        t.setDate(rs.getDate("date"));
        t.setDescription(rs.getString("description"));
        t.setProjet(projetRowMapper.mapRow(rs, i));
        t.setStatut(ticketStatutRowMapper.mapRow(rs, i));

        return t;

    }
}

