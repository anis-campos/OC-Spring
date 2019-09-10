package org.example.demo.ticket.consumer.impl.factory;

import org.example.demo.ticket.consumer.dao.ProjetDao;
import org.example.demo.ticket.consumer.dao.TicketDao;
import org.example.demo.ticket.consumer.factory.DaoFactory;

class DaoFactoryImpl implements DaoFactory {

    private ProjetDao projectDao;
    private TicketDao ticketDao;

    @Override
    public ProjetDao projectDao() {
        return projectDao;
    }

    @Override
    public TicketDao ticketDao() {
        return ticketDao;
    }

    public void setProjectDao(ProjetDao projectDao) {
        this.projectDao = projectDao;
    }

    public ProjetDao getProjectDao() {
        return projectDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }
}
