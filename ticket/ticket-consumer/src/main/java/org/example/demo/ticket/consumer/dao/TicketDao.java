package org.example.demo.ticket.consumer.dao;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

import java.util.List;

public interface TicketDao {

    Ticket getById(Integer pId);

    List<Ticket> search(RechercheTicket pRechercheTicket);
}