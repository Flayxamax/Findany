/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.dtos;

import java.util.Date;
import org.hired.findanyobjetosnegocio.TipoPost;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author wikit
 */
public class CrearPostDTO {
    private Date fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private Usuario usuarioAutor;
    private TipoPost tipo;

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
        return tipo;
    }

    public void setTipo(TipoPost tipo) {
        this.tipo = tipo;
    }
}

