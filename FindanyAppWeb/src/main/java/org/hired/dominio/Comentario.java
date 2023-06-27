/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dominio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author ildex
 */
public class Comentario {

    private ObjectId id;
    private Date fechaHora;
    private String contenido;
    private Normal normal;
    private Comentario comentario;
    private Comun comun;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, Normal normal, Comentario comentario, Comun comun) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.normal = normal;
        this.comentario = comentario;
        this.comun = comun;
    }

    public Comentario(ObjectId id, Date fechaHora, String contenido, Normal normal, Comentario comentario, Comun comun) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.normal = normal;
        this.comentario = comentario;
        this.comun = comun;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Comun getComun() {
        return comun;
    }

    public void setComun(Comun comun) {
        this.comun = comun;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", normal=" + normal + ", comentario=" + comentario + ", comun=" + comun + '}';
    }

}
