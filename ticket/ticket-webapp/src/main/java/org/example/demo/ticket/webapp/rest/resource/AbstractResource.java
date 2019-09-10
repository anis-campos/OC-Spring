package org.example.demo.ticket.webapp.rest.resource;

import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractResource {
    @Autowired
    protected ProjetManager projetManager;

    @Autowired
    protected TicketManager ticketManager;
}
