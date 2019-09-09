package org.example.demo.ticket.consumer.dao;


import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;

import java.util.List;

public interface ProjetDao {

    Projet getById(Integer pId);

    List<Projet> getAll();
}