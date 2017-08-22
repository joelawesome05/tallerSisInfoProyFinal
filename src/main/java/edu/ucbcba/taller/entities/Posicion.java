package edu.ucbcba.taller.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by HP on 20/8/2017.
 */
@Entity
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String nombre;

    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL)
    private Set<Futbolista> futbolistas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(Set<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }
}
