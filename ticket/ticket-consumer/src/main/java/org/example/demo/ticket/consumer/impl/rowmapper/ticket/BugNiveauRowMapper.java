package org.example.demo.ticket.consumer.impl.rowmapper.ticket;

import org.example.demo.ticket.model.bean.ticket.BugNiveau;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BugNiveauRowMapper implements RowMapper<BugNiveau> {

    @Override
    public BugNiveau mapRow(ResultSet rs, int i) throws SQLException {
        BugNiveau bn = new BugNiveau();
        bn.setId(rs.getInt("bug_niveau_id"));
        bn.setLibelle(rs.getString("bug_niveau_libelle"));
        bn.setOrdre(rs.getInt("bug_niveau_ordre"));
        return bn;
    }
}
