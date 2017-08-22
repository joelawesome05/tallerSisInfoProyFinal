package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Posicion;
import edu.ucbcba.taller.repositories.PosicionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by HP on 20/8/2017.
 */
@Service
public class PosicionServicioImpl implements PosicionServicio {

    private PosicionRepositorio posicionRepositorio;

    @Autowired
    @Qualifier(value = "posicionRepositorio")
    public void setPosicionRepositorio(PosicionRepositorio posicionRepositorio) {
        this.posicionRepositorio = posicionRepositorio;
    }

    @Override
    public Iterable<Posicion> listAllPosiciones() {
        return posicionRepositorio.findAll();
    }

    @Override
    public Posicion getPosicionById(Integer id) {
        return posicionRepositorio.findOne(id);
    }

    @Override
    public Posicion savePosicion(Posicion posicion) {
        return posicionRepositorio.save(posicion);
    }

    @Override
    public void deletePosicion(Integer id) {
        posicionRepositorio.delete(id);
    }
}
