/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dtos;

import java.util.Date;
import org.bson.types.ObjectId;
import org.hired.findanyobjetosnegocio.TipoPost;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author wikit
 */
public class CrearPostDTO {
    private ObjectId id;
    private Date fechaHoraCreacion;
    private Date fechaHoraEdicion;
    private String titulo;
    private String contenido;
    private Usuario usuarioAutor;
    private boolean tipo;

    // Agrega constructor, getters y setters de los campos

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public TipoPost getTipo() {
        if (tipo){
            return TipoPost.ANCLADO;
        }
        return TipoPost.COMUN;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
    
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}

