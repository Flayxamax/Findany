/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author ildex
 */
public class Comun {

    private ObjectId id;
    private List<Comentario> comentario;
    private Usuario usuario;

    public Comun() {
    }

    public Comun(List<Comentario> comentario, Usuario usuario) {
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public Comun(ObjectId id, List<Comentario> comentario, Usuario usuario) {
        this.id = id;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Comun other = (Comun) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Comun{" + "id=" + id + ", comentario=" + comentario + ", usuario=" + usuario + '}';
    }

}
