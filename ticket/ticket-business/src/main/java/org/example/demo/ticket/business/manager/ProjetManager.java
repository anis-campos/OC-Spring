package org.example.demo.ticket.business.manager;


import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager des beans du package Projet.
 *
 * @author lgu
 */
public class ProjetManager {

    private DaoFactory daoFactory;


    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    public Projet getProjet(Integer pId) throws NotFoundException {
        Projet p = daoFactory.projectDao().getById(pId);
        if (p == null) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        return p;
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    public List<Projet> getListProjet() {
        return daoFactory.projectDao().getAll();
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
