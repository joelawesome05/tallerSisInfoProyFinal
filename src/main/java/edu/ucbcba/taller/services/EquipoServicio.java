package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Equipo;

/**
 * Created by HP on 20/8/2017.
 */
public interface EquipoServicio {

    Iterable<Equipo> listAllEquipos();

    Equipo getEquipoById(Integer id);

    Equipo saveEquipo(Equipo equipo);

    void deleteEquipo(Integer id);
}
