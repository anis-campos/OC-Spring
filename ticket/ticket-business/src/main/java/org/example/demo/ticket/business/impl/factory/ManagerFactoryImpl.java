package org.example.demo.ticket.business.impl.factory;

import org.example.demo.ticket.business.factory.ManagerFactory;
import org.example.demo.ticket.business.manager.ProjectManager;
import org.example.demo.ticket.business.manager.TicketManager;

public class ManagerFactoryImpl implements ManagerFactory {


    private ProjectManager projectManager;
    private TicketManager ticketManager;

    @Override
    public ProjectManager projectManager() {
        return projectManager;
    }

    @Override
    public TicketManager ticketManager() {
        return ticketManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public void setTicketManager(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
    }
}
