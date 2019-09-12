package org.example.demo.ticket.consumer.impl.rowmapper.project;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProjetRowMapper implements RowMapper<Projet> {

    @Autowired
    private RowMapper<Utilisateur> uRM;

    @Override
    public Projet mapRow(ResultSet resultSet, int i) throws SQLException {
        Projet projet = new Projet(resultSet.getInt("projet_id"));
        projet.setNom(resultSet.getString("projet_nom"));
        projet.setCloture(resultSet.getBoolean("projet_cloture"));
        projet.setDateCreation(resultSet.getDate("projet_date_creation"));
        projet.setResponsable(uRM.mapRow(resultSet, i));
        return projet;
    }
}
