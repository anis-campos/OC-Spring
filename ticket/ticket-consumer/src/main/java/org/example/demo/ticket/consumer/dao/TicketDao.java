package org.example.demo.ticket.consumer.dao;

import org.example.demo.ticket.model.bean.ticket.Ticket;

public interface TicketDao {

    Ticket getById(Integer pId);
}