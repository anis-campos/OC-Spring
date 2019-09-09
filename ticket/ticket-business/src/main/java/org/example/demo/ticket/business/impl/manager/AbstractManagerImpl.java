package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.consumer.factory.DaoFactory;


public abstract class AbstractManagerImpl {


    private DaoFactory daoFactory;

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
