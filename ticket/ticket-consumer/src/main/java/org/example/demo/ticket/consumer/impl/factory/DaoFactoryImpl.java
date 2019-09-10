package org.example.demo.ticket.consumer.impl.factory;

import org.example.demo.ticket.consumer.dao.TicketDao;
import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.example.demo.ticket.consumer.dao.ProjetDao;
import org.example.demo.ticket.consumer.impl.dao.ProjetDaoImpl;

class DaoFactoryImpl implements DaoFactory {

    private ProjetDaoImpl projectDao;
    private TicketDao ticketDao;

    @Override
    public ProjetDao projectDao() {
        return projectDao;
    }

    @Override
    public TicketDao ticketDao() {
        return ticketDao;
    }

    public void setProjectDao(ProjetDaoImpl projectDao) {
        this.projectDao = projectDao;
    }

    public ProjetDaoImpl getProjectDao() {
        return projectDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }
}
