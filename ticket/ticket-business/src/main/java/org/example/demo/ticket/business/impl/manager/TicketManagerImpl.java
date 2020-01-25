package org.example.demo.ticket.business.impl.manager;

import org.example.demo.ticket.business.manager.TicketManager;
import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

import java.util.List;

class TicketManagerImpl extends AbstractManagerImpl implements TicketManager {
    public TicketManagerImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    /**4s
     * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
     *
     * @param pNumero le numéro du Ticket
     * @return Le {@link Ticket}
     * @throws NotFoundException Si le Ticket n'est pas trouvé
     */
    public Ticket getTicket(Long pNumero) throws NotFoundException {
        return ticketDao.getById(pNumero);
    }


    /**
     * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return List
     */
    public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {

        return ticketDao.search(pRechercheTicket);

    }


    /**
     * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return int
     */
    public int getCountTicket(RechercheTicket pRechercheTicket) {
        return ticketDao.count(pRechercheTicket);
    }
}
