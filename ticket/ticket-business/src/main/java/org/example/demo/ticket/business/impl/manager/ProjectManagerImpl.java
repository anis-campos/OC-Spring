package org.example.demo.ticket.business.impl.manager;


import org.example.demo.ticket.business.manager.ProjectManager;
import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;


/**
 * Manager des beans du package Projet.
 *
 * @author lgu
 */
class ProjectManagerImpl extends AbstractManagerImpl implements ProjectManager {


    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    public Projet getProjet(Integer pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        return getDaoFactory().projectDao().getById(pId);

    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    public List<Projet> getListProjet() {
        return getDaoFactory().projectDao().getAll();
    }
}
