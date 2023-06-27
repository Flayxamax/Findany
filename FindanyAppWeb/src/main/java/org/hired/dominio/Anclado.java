/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author ildex
 */
public class Anclado {

    private ObjectId id;
    private Admor admor;

    public Anclado() {
    }

    public Anclado(Admor admor) {
        this.admor = admor;
    }

    public Anclado(ObjectId id, Admor admor) {
        this.id = id;
        this.admor = admor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Admor getAdmor() {
        return admor;
    }

    public void setAdmor(Admor admor) {
        this.admor = admor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Anclado other = (Anclado) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Anclado{" + "id=" + id + ", admor=" + admor + '}';
    }

}
