package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;

import java.util.List;

class ProjetManagerImpl extends AbstractManagerImpl implements ProjetManager {

    public ProjetManagerImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    public Projet getProjet(Integer pId) throws NotFoundException {
        Projet p = projectDao.getById(pId);
        if (p == null) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        return p;
    }

    public List<Projet> getListProjet() {
        return projectDao.getAll();
    }

}
