package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.dao.ProjetDao;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class ProjetDaoImpl extends AbstractDaoImpl implements ProjetDao {

    @Autowired
    private RowMapper<Projet> projetRowMapper;

    @Override
    public Projet getById(Integer pId) {

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("project_id", pId);

        return template.queryForObject("SELECT " +
                "p.id as projet_id, " +
                "p.nom as projet_nom, " +
                "p.date_creation as projet_date_creation, " +
                "p.cloture as projet_cloture, " +
                "p.responsable_id as projet_responsable_id, " +
                "u.id as u_id, " +
                "u.nom as u_nom, " +
                "u.prenom as u_prenom " +
                "FROM projet p " +
                "JOIN utilisateur u on p.responsable_id = u.id  " +
                "where id = :project_id", parameters, projetRowMapper);

    }

    @Override
    public List<Projet> getAll() {
        JdbcTemplate template = new JdbcTemplate(getDataSource());
        return template.query("SELECT " +
                "p.id as projet_id, " +
                "p.nom as projet_nom, " +
                "p.date_creation as projet_date_creation, " +
                "p.cloture as projet_cloture, " +
                "p.responsable_id as projet_responsable_id, " +
                "u.id as u_id, " +
                "u.nom as u_nom, " +
                "u.prenom as u_prenom " +
                "FROM projet p " +
                "JOIN utilisateur u on p.responsable_id = u.id", projetRowMapper);
    }
}

