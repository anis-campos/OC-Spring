package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.dao.TicketDao;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {

    @Autowired
    private RowMapper<Ticket> rowMapper;

    @Override
    public Ticket getById(Integer pId) {


        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ticket_id", pId);

        return template.queryForObject("SELECT * FROM ticket where numero = :ticket_id", parameters, rowMapper);


    }

    @Override
    public List<Ticket> search(RechercheTicket pRechercheTicket) {

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        String criteria = " where";

        if (pRechercheTicket.getProjetId() != null) {
            parameters.addValue("project_id", pRechercheTicket.getProjetId());
            criteria += " project_id=:project_id AND";
        }
        if (pRechercheTicket.getAuteurId() != null) {
            parameters.addValue("auteur_id", pRechercheTicket.getAuteurId());
            criteria += " auteur_id=:auteur_id AND";
        }
        criteria += " 1=1";

        return template.query("SELECT * FROM ticket t  " +
                "LEFT JOIN bug b on t.numero = b.ticket_numero " +
                "LEFT JOIN evolution e on t.numero = e.ticket_numero" +
                criteria, parameters, rowMapper);


    }
}

