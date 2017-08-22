package edu.ucbcba.taller.entities;

/**
 * Created by HP on 13/8/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotNull
    @Size(min = 2,max = 35,message = "Nombre del jugador tiene un tamaño permitido solo entre 2 y 35")
    private String nombre;

    @NotNull
    @Size(min = 2,max = 35,message = "Apellido del jugador tiene un tamaño permitido solo entre 2 y 35")
    private String apellido;

    @NotNull
    private String apodo;


    @NotNull(message = "Por favor, Ingrese el peso del jugador")
    @DecimalMin(value = "30", message = "Por favor, Ingrese un peso coherente")
    @DecimalMax(value = "200", message = "Por favor, Ingrese un peso coherente")
    private BigDecimal peso;


    @NotNull(message = "Por favor, Ingrese la altura del jugador")
    @DecimalMin(value = "1", message = "Por favor, Ingrese una altura coherente")
    @DecimalMax(value = "2.5", message = "Por favor, Ingrese una altura coherente")
    private BigDecimal altura;

    @NotNull(message = "Por favor, Ingrese el dorsal del jugador")
    @Min(value = 1, message = "Por favor, Ingrese un número coherente")
    @Max(value = 99, message = "Por favor, Ingrese un número coherente")
    private Integer dorsal;

    @NotNull
    @Size(min = 2,max = 20,message = "Nacionalidad del jugador tiene un tamaño permitido solo entre 2 y 20")
    private String nacionalidad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Por favor, Ingrese una fecha de nacimiento coherente")
    @NotNull(message = "Por favor, Ingrese la fecha de nacimiento del jugador")
    private Date nacimiento;

    @ManyToOne
    @JoinColumn(name = "posicion_id")
    private Posicion posicion;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
}


