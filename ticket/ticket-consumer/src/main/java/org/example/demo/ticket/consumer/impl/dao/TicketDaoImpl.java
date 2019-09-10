package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.dao.TicketDao;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {
    @Override
    public Ticket getById(Integer pId) {


        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ticket_id", pId);

        return template.queryForObject("SELECT * FROM ticket where numero = :ticket_id", parameters, Ticket.class);


    }
}
