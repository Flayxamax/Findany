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
public class Admor extends Usuario {

    private ObjectId id;
    private List<Anclado> anclado;

    public Admor() {
    }

    public Admor(List<Anclado> anclado) {
        this.anclado = anclado;
    }

    public Admor(ObjectId id, List<Anclado> anclado) {
        this.id = id;
        this.anclado = anclado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Anclado> getAnclado() {
        return anclado;
    }

    public void setAnclado(List<Anclado> anclado) {
        this.anclado = anclado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Admor other = (Admor) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Admor{" + "id=" + id + ", anclado=" + anclado + '}';
    }

}
