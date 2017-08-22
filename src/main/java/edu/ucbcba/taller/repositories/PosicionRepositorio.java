package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by HP on 20/8/2017.
 */

@Transactional
public interface PosicionRepositorio extends JpaRepository<Posicion,Integer> {
}
