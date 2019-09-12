package org.example.demo.ticket.consumer.impl.rowmapper.project;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UtilisateurRowMapper implements RowMapper<Utilisateur> {

    @Override
    public Utilisateur mapRow(ResultSet rs, int i) throws SQLException {
        Utilisateur u = new Utilisateur(rs.getInt("u_id"));
        u.setNom(rs.getString("u_nom"));
        u.setPrenom(rs.getString("u_prenom"));
        return u;
    }
}
