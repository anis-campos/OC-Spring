package org.example.demo.ticket.webapp.rest.resource;

import org.example.demo.ticket.business.factory.ManagerFactory;

public abstract class AbstractResource {


    private ManagerFactory managerFactory;

    protected ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }
}
