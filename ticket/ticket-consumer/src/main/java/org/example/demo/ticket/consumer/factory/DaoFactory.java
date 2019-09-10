package org.example.demo.ticket.consumer.factory;

import org.example.demo.ticket.consumer.dao.ProjetDao;
import org.example.demo.ticket.consumer.dao.TicketDao;

public interface DaoFactory {

    ProjetDao projectDao();

    TicketDao ticketDao();

}
