/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.objetosNegocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ildex
 */
@Entity
@Table(name = "post")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_hora_creacion", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime fechaHoraCreacion;
    
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    
    @Column(name = "contenido", nullable = false, length = 500)
    private String contenido;
    
    @Column(name = "fecha_hora_edicion", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime fechaHoraEdicion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hired.objetosNegocio.Post[ id=" + id + " ]";
    }
    
}
