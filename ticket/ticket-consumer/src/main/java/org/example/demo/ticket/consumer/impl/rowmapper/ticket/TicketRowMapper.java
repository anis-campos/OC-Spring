package org.example.demo.ticket.consumer.impl.rowmapper.ticket;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
       Ticket t;
       return t;

    }
}
