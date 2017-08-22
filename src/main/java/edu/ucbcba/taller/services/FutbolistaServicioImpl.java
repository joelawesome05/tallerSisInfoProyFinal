package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Futbolista;
import edu.ucbcba.taller.repositories.FutbolistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by HP on 13/8/2017.
 */
@Service
public class FutbolistaServicioImpl implements FutbolistaServicio{

    private FutbolistaRepositorio futbolistaRepositorio;

    @Autowired
    @Qualifier(value = "futbolistaRepositorio")
    public void setFutbolistaRepositorio(FutbolistaRepositorio futbolistaRepositorio) {
        this.futbolistaRepositorio = futbolistaRepositorio;
    }


    @Override
    public Iterable<Futbolista> listAllFutbolistas() {
        return futbolistaRepositorio.findAll();
    }

    @Override
    public Futbolista getFutbolistaById(Integer id) {
        return futbolistaRepositorio.findOne(id);
    }

    @Override
    public Futbolista saveFutbolista(Futbolista futbolista) {
        return futbolistaRepositorio.save(futbolista);
    }

    @Override
    public void deleteFutbolista(Integer id) {
        futbolistaRepositorio.delete(id);
    }
}
