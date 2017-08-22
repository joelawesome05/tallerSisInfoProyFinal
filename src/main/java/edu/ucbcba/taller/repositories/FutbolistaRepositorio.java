package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by HP on 13/8/2017.
 */

@Transactional
public interface FutbolistaRepositorio extends JpaRepository<Futbolista,Integer> {
}
