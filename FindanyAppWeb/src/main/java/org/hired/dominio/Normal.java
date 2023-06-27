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
public class Normal extends Usuario {

    private ObjectId id;
    private List<Comentario> comentario;

    public Normal() {
    }

    public Normal(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Normal(ObjectId id) {
        this.id = id;
    }

    public Normal(ObjectId id, List<Comentario> comentario) {
        this.id = id;
        this.comentario = comentario;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Normal other = (Normal) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Normal{" + "id=" + id + ", comentario=" + comentario + '}';
    }

}
