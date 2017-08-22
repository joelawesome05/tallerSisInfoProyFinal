package edu.ucbcba.taller.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HP on 20/8/2017.
 */
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotNull
    @Size(min = 2,max = 35,message = "Nombre del equipo tiene un tamaño permitido solo entre 2 y 35")
    private String nombre;

    @NotNull
    private String apodo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Por favor, Ingrese una fecha de fundacion coherente")
    @NotNull(message = "Por favor, Ingrese la fecha de fundacion del equipo de fútbol")
    private Date fundacion;

    @NotNull
    @Size(min = 2,max = 40,message = "Nombre del presidente tiene un tamaño permitido solo entre 2 y 40")
    private String presidente;

    @NotNull
    @Size(min = 2,max = 40,message = "Nombre del entrenador tiene un tamaño permitido solo entre 2 y 40")
    private String entrenador;

    @NotNull
    @Size(min = 2,max = 40,message = "Nombre del estadio tiene un tamaño permitido solo entre 2 y 40")
    private String estadio;

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

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
}
