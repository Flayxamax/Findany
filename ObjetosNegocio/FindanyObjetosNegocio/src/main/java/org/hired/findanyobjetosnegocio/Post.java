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
 * La clase Post representa un post en una plataforma. Contiene información como
 * el identificador, fecha y hora de creación, título, contenido, imagen, fecha
 * y hora de edición, usuario autor y tipo de post.
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

    /**
     * Crea una instancia vacía de la clase Post.
     */
    public Post() {
    }

    /**
     * Crea una instancia de la clase {@code Post} con los datos especificados.
     *
     * @param fechaHoraCreacion la fecha y hora de creación del post
     * @param titulo el título del post
     * @param contenido el contenido del post
     * @param imagen la imagen asociada al post
     * @param fechaHoraEdicion la fecha y hora de edición del post
     * @param usuarioAutor el usuario que ha creado el post
     * @param tipo el tipo de post
     */
    public Post(Date fechaHoraCreacion, String titulo, String contenido, Binary imagen, Date fechaHoraEdicion, Usuario usuarioAutor, TipoPost tipo) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.usuarioAutor = usuarioAutor;
        this.tipo = tipo;
    }

    /**
     * Crea una instancia de la clase Post con el identificador y los datos
     * especificados.
     *
     * @param id el identificador del post
     * @param fechaHoraCreacion la fecha y hora de creación del post
     * @param titulo el título del post
     * @param contenido el contenido del post
     * @param imagen la imagen asociada al post
     * @param fechaHoraEdicion la fecha y hora de edición del post
     * @param usuarioAutor el usuario que ha creado el post
     * @param tipo el tipo de post
     */
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

    /**
     * Devuelve el identificador del post.
     *
     * @return el identificador del post
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del post.
     *
     * @param id el identificador del post
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha y hora de creación del post.
     *
     * @return la fecha y hora de creación del post
     */
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación del post.
     *
     * @param fechaHoraCreacion la fecha y hora de creación del post
     */
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Devuelve el título del post.
     *
     * @return el título del post
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del post.
     *
     * @param titulo el título del post
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el contenido del post.
     *
     * @return el contenido del post
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del post.
     *
     * @param contenido el contenido del post
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve la imagen asociada al post.
     *
     * @return la imagen asociada al post
     */
    public Binary getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen asociada al post.
     *
     * @param imagen la imagen asociada al post
     */
    public void setImagen(Binary imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve la fecha y hora de edición del post.
     *
     * @return la fecha y hora de edición del post
     */
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora de edición del post.
     *
     * @param fechaHoraEdicion la fecha y hora de edición del post
     */
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Devuelve el usuario autor del post.
     *
     * @return el usuario autor del post
     */
    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    /**
     * Establece el usuario autor del post.
     *
     * @param usuarioAutor el usuario autor del post
     */
    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    /**
     * Devuelve el tipo de post.
     *
     * @return el tipo de post
     */
    public TipoPost getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de post.
     *
     * @param tipo el tipo de post
     */
    public void setTipo(TipoPost tipo) {
        this.tipo = tipo;
    }

    /**
     * Calcula el hash code del post.
     *
     * @return el hash code del post
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el post actual con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar
     * @return true si el post y el objeto son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del post.
     *
     * @return una cadena que representa el post
     */
    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", fechaHoraCreacion=" + fechaHoraCreacion
                + ", titulo='" + titulo + '\''
                + ", contenido='" + contenido + '\''
                + ", fechaHoraEdicion=" + fechaHoraEdicion
                + '}';
    }

}
