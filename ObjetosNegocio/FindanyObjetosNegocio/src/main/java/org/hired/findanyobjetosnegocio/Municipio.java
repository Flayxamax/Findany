/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.findanyobjetosnegocio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * La clase Municipio representa un municipio. Contiene información como el
 * identificador, nombre, lista de usuarios asociados y el estado al que
 * pertenece.
 *
 * @author HIRED
 */
public class Municipio {

    private ObjectId id;
    private String nombre;
    private List<Usuario> usuario;
    private ObjectId estado;

    /**
     * Crea una instancia vacía de la clase {@code Municipio}.
     */
    public Municipio() {
    }

    /**
     * Crea una instancia de la clase Municipio con el nombre especificado.
     *
     * @param nombre el nombre del municipio
     */
    public Municipio(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea una instancia de la clase Municipio con el nombre y estado
     * especificados.
     *
     * @param nombre el nombre del municipio
     * @param estado el estado al que pertenece el municipio
     */
    public Municipio(String nombre, ObjectId estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    /**
     * Crea una instancia de la clase Municipio con el nombre, lista de usuarios
     * y estado especificados.
     *
     * @param nombre el nombre del municipio
     * @param usuario la lista de usuarios asociados al municipio
     * @param estado el estado al que pertenece el municipio
     */
    public Municipio(String nombre, List<Usuario> usuario, ObjectId estado) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.estado = estado;
    }

    /**
     * Crea una instancia de la clase Municipio con el identificador, nombre,
     * lista de usuarios y estado especificados.
     *
     * @param id el identificador del municipio
     * @param nombre el nombre del municipio
     * @param usuario la lista de usuarios asociados al municipio
     * @param estado el estado al que pertenece el municipio
     */
    public Municipio(ObjectId id, String nombre, List<Usuario> usuario, ObjectId estado) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.estado = estado;
    }

    /**
     * Devuelve el identificador del municipio.
     *
     * @return el identificador del municipio
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del municipio.
     *
     * @param id el identificador del municipio
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del municipio.
     *
     * @return el nombre del municipio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     *
     * @param nombre el nombre del municipio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de usuarios asociados al municipio.
     *
     * @return la lista de usuarios asociados al municipio
     */
    public List<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * Establece la lista de usuarios asociados al municipio.
     *
     * @param usuario la lista de usuarios asociados al municipio
     */
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el estado al que pertenece el municipio.
     *
     * @return el estado al que pertenece el municipio
     */
    public ObjectId getEstado() {
        return estado;
    }

    /**
     * Establece el estado al que pertenece el municipio.
     *
     * @param estado el estado al que pertenece el municipio
     */
    public void setEstado(ObjectId estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el código hash del municipio.
     *
     * @return el código hash del municipio
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el municipio con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar
     * @return {@code true} si el municipio es igual al objeto especificado,
     * {@code false} de lo contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Municipio other = (Municipio) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una cadena que representa el municipio.
     *
     * @return una cadena que representa el municipio
     */
    @Override
    public String toString() {
        return "Municipio{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", usuario=" + usuario
                + ", estado=" + estado
                + '}';
    }

}
