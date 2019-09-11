package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.consumer.dao.ProjetDao;
import org.example.demo.ticket.consumer.dao.TicketDao;
import org.example.demo.ticket.consumer.factory.DaoFactory;

abstract class AbstractManagerImpl {


    final TicketDao ticketDao;
    final ProjetDao projectDao;

    AbstractManagerImpl(DaoFactory daoFactory) {
        this.ticketDao = daoFactory.ticketDao();
        this.projectDao = daoFactory.projectDao();
    }
}
