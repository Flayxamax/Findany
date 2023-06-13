/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.objetosNegocio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ildex
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_usuario_admor")
@Table(name = "usuario_admor")
public class Admor extends Usuario {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admor", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "anclado", targetEntity = Anclado.class)
    private List<Anclado> anclado;

    public Admor() {
    }

    public Admor(Long id, List<Anclado> anclado) {
        this.id = id;
        this.anclado = anclado;
    }

    public Admor(List<Anclado> anclado) {
        this.anclado = anclado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admor)) {
            return false;
        }
        Admor other = (Admor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hired.objetosNegocio.Admor[ id=" + id + " ]";
    }

}
