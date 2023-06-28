/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.findanyobjetosnegocio;

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
    private Comentario comentario;
    private Usuario usuarioAutor;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, Comentario comentario, Usuario usuarioAutor) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comentario = comentario;
        this.usuarioAutor = usuarioAutor;
    }

    public Comentario(ObjectId id, Date fechaHora, String contenido, Comentario comentario, Usuario usuarioAutor) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comentario = comentario;
        this.usuarioAutor = usuarioAutor;
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
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
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", comentario=" + comentario + ", usuarioAutor=" + usuarioAutor + '}';
    }

}
