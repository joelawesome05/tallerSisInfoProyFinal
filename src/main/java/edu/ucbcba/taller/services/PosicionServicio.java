package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Posicion;

/**
 * Created by HP on 20/8/2017.
 */
public interface PosicionServicio {
    Iterable<Posicion> listAllPosiciones();

    Posicion getPosicionById(Integer id);

    Posicion savePosicion(Posicion posicion);

    void deletePosicion(Integer id);
}
