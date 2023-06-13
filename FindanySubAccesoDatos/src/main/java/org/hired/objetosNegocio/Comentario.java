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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ildex
 */
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime fechaHora;

    @Column(name = "contenido", nullable = false, length = 200)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id_normal", nullable = false)
    private Normal normal;

    @ManyToOne
    @JoinColumn(name = "id_comentario", nullable = false)
    private Comentario comentario;

    @ManyToOne
    @JoinColumn(name = "id_comun", nullable = false)
    private Comun comun;

    public Comentario() {
    }

    public Comentario(Long id, LocalDateTime fechaHora, String contenido, Normal normal, Comentario comentario, Comun comun) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.normal = normal;
        this.comentario = comentario;
        this.comun = comun;
    }

    public Comentario(LocalDateTime fechaHora, String contenido, Normal normal, Comentario comentario, Comun comun) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.normal = normal;
        this.comentario = comentario;
        this.comun = comun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hired.objetosNegocio.Comentario[ id=" + id + " ]";
    }

}
