package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Equipo;
import edu.ucbcba.taller.repositories.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by HP on 20/8/2017.
 */

@Service
public class EquipoServicioImpl implements EquipoServicio {

    private EquipoRepositorio equipoRepositorio;

    @Autowired
    @Qualifier(value = "equipoRepositorio")
    public void setEquipoRepositorio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }


    @Override
    public Iterable<Equipo> listAllEquipos() {
        return equipoRepositorio.findAll();
    }

    @Override
    public Equipo getEquipoById(Integer id) {
        return equipoRepositorio.findOne(id);
    }

    @Override
    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    @Override
    public void deleteEquipo(Integer id) {
        equipoRepositorio.delete(id);
    }
}
