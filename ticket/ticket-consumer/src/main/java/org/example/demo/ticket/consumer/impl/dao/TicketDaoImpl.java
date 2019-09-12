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
            parameters.addValue("projet_id", pRechercheTicket.getProjetId());
            criteria += " projet_id=:projet_id AND";
        }
        if (pRechercheTicket.getAuteurId() != null) {
            parameters.addValue("auteur_id", pRechercheTicket.getAuteurId());
            criteria += " auteur_id=:auteur_id AND";
        }
        criteria += " 1=1";

        return template.query(
                "SELECT " +
                        "t.numero, " +
                        "t.titre, " +
                        "t.date, " +
                        "t.description, " +
//                        "t.statut_actuel_id, " +
//                        "t.auteur_id, " +
//                        "t.projet_id, " +
                        "s.id as statut_id, " +
                        "s.libelle as statut_libelle, " +
                        "b.ticket_numero as bug_id, " +
                        "b.niveau_bug_id as bug_niveau_id, " +
                        "bn.ordre as bug_niveau_ordre, " +
                        "bn.libelle as bug_niveau_libelle, " +
                        "e.ticket_numero as evolution_id, " +
                        "e.priorite as evolution_priorite " +
                        "FROM ticket t " +
                        "LEFT JOIN statut s on t.statut_actuel_id = s.id " +
                        "LEFT JOIN bug b on t.numero = b.ticket_numero " +
                        "LEFT JOIN niveau_bug bn on t.numero = bn.id " +
                        "LEFT JOIN evolution e on t.numero = e.ticket_numero " +
                        criteria, parameters, rowMapper);


    }
}

