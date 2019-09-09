package org.example.demo.ticket.business.factory;

import org.example.demo.ticket.business.manager.ProjectManager;
import org.example.demo.ticket.business.manager.TicketManager;

public interface ManagerFactory {
    ProjectManager projectManager();
    TicketManager ticketManager();
}
