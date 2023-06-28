/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.findanyobjetosnegocio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author ildex
 */
public class Post {

    private ObjectId id;
    private Date fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private Binary imagen;
    private Date fechaHoraEdicion;
    private Usuario usuarioAutor;
    private TipoPost tipo;

    public Post() {
    }

    public Post(Date fechaHoraCreacion, String titulo, String contenido, Binary imagen, Date fechaHoraEdicion, Usuario usuarioAutor, TipoPost tipo) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.usuarioAutor = usuarioAutor;
        this.tipo = tipo;
    }

    public Post(ObjectId id, Date fechaHoraCreacion, String titulo, String contenido, Binary imagen, Date fechaHoraEdicion, Usuario usuarioAutor, TipoPost tipo) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.usuarioAutor = usuarioAutor;
        this.tipo = tipo;
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

    public Binary getImagen() {
        return imagen;
    }

    public void setImagen(Binary imagen) {
        this.imagen = imagen;
    }

    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public TipoPost getTipo() {
        return tipo;
    }

    public void setTipo(TipoPost tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Post other = (Post) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }

}
