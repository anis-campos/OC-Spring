package org.example.demo.ticket.consumer.impl.rowmapper.project;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProjetRowMapper implements RowMapper<Projet> {

    @Override
    public Projet mapRow(ResultSet resultSet, int i) throws SQLException {
        Projet projet = new Projet(resultSet.getInt("id"));
        projet.setNom(resultSet.getString("nom"));
        projet.setCloture(resultSet.getBoolean("cloture"));
        projet.setDateCreation(resultSet.getDate("date_creation"));
        projet.setResponsable(new Utilisateur(resultSet.getInt("responsable_id")));
        return projet;
    }
}
