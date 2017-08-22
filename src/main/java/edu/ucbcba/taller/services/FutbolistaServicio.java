package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Futbolista;

/**
 * Created by HP on 13/8/2017.
 */


public interface FutbolistaServicio {

    Iterable<Futbolista> listAllFutbolistas();

    Futbolista getFutbolistaById(Integer id);

    Futbolista saveFutbolista(Futbolista futbolista);

    void deleteFutbolista(Integer id);
}
