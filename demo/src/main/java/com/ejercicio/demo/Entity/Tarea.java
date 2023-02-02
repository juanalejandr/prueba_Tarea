package com.ejercicio.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "Descripcion", nullable = false)
    @JsonProperty(value = "descripcion")
    private String descripcion;

    @Column(name = "Fecha creacion", nullable = false)
    @JsonProperty(value = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "Vigente", nullable = false)
    @JsonProperty(value = "Vigente")
    private boolean vigente;

    public Tarea(Long id, String descripcion, Date fechaCreacion, boolean vigente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.vigente = vigente;
    }

    public Tarea() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean getVigente() {
        return vigente;
    }
}
