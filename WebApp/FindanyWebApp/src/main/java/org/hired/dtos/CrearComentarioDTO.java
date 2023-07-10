/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dtos;

import java.util.Date;
import org.bson.types.ObjectId;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author xeron
 */
public class CrearComentarioDTO {

    private ObjectId id;
    private Date fechaHoraCreacion;
    private String contenido;
    private String usuarioAutor;
    private String comentarioPadre;

    public CrearComentarioDTO() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(String usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public String getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(String comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

}
