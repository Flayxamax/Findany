/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.findanyobjetosnegocio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * La clase Comentario representa un comentario en el sistema. Contiene
 * información como el identificador, fecha y hora de creación, contenido del
 * comentario, el comentario padre al que responde (si existe), y el usuario
 * autor del comentario.
 *
 * @author Findany
 */
public class Comentario {

    private ObjectId id;
    private Date fechaHora;
    private String contenido;
    private Comentario comentario;
    private Usuario usuarioAutor;
    private ObjectId comentarioPadre;

    /**
     * Crea una nueva instancia de {@code Comentario} con valores
     * predeterminados para sus propiedades.
     */
    public Comentario() {
    }

    /**
     * Crea una nueva instancia de Comentario con los valores especificados para
     * sus propiedades.
     *
     * @param id el identificador del comentario
     * @param fechaHora la fecha y hora de creación del comentario
     * @param contenido el contenido del comentario
     * @param comentario el comentario padre al que responde (puede ser null)
     * @param usuarioAutor el usuario autor del comentario
     */
    public Comentario(ObjectId id, Date fechaHora, String contenido, Comentario comentario, Usuario usuarioAutor) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioAutor = usuarioAutor;
    }

    /**
     * Crea una nueva instancia de Comentario con los valores especificados para
     * sus propiedades.
     *
     * @param id el identificador del comentario
     * @param fechaHora la fecha y hora de creación del comentario
     * @param contenido el contenido del comentario
     * @param usuarioAutor el usuario autor del comentario
     * @param comentarioPadre el identificador del comentario padre al que
     * responde (puede ser null)
     */
    public Comentario(ObjectId id, Date fechaHora, String contenido, Usuario usuarioAutor, ObjectId comentarioPadre) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioAutor = usuarioAutor;
        this.comentarioPadre = comentarioPadre;
    }

    /**
     * Obtiene el identificador del comentario.
     *
     * @return el identificador del comentario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del comentario.
     *
     * @param id el identificador del comentario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de creación del comentario.
     *
     * @return la fecha y hora de creación del comentario
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de creación del comentario.
     *
     * @param fechaHora la fecha y hora de creación del comentario
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return el contenido del comentario
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido el contenido del comentario
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el usuario autor del comentario.
     *
     * @return el usuario autor del comentario
     */
    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    /**
     * Establece el usuario autor del comentario.
     *
     * @param usuarioAutor el usuario autor del comentario
     */
    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    /**
     * Obtiene el identificador del comentario padre al que responde.
     *
     * @return el identificador del comentario padre al que responde
     */
    public ObjectId getComentarioPadre() {
        return comentarioPadre;
    }

    /**
     * Establece el identificador del comentario padre al que responde.
     *
     * @param comentarioPadre el identificador del comentario padre al que
     * responde
     */
    public void setComentarioPadre(ObjectId comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.fechaHora);
        hash = 59 * hash + Objects.hashCode(this.contenido);
        hash = 59 * hash + Objects.hashCode(this.comentario);
        hash = 59 * hash + Objects.hashCode(this.usuarioAutor);
        hash = 59 * hash + Objects.hashCode(this.comentarioPadre);
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.usuarioAutor, other.usuarioAutor)) {
            return false;
        }
        return Objects.equals(this.comentarioPadre, other.comentarioPadre);
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", comentario=" + comentario + ", usuarioAutor=" + usuarioAutor + ", comentarioPadre=" + comentarioPadre + '}';
    }
}
