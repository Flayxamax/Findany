/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.findanyobjetosnegocio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * La clase {@code Estado} representa un estado. Contiene información como el
 * identificador, nombre y la lista de municipios asociados.
 *
 * @author Findany
 *
 */
public class Estado {

    private ObjectId id;
    private String nombre;
    private List<Municipio> municipio;

    /**
     * Crea una instancia vacía de la clase {@code Estado}.
     */
    public Estado() {
    }

    /**
     * Crea una instancia de la clase {@code Estado} con el nombre especificado.
     *
     * @param nombre el nombre del estado
     */
    public Estado(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea una instancia de la clase {@code Estado} con el nombre y la lista de
     * municipios especificados.
     *
     * @param nombre el nombre del estado
     * @param municipio la lista de municipios asociados al estado
     */
    public Estado(String nombre, List<Municipio> municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
    }

    /**
     * Crea una instancia de la clase {@code Estado} con el identificador,
     * nombre y la lista de municipios especificados.
     *
     * @param id el identificador del estado
     * @param nombre el nombre del estado
     * @param municipio la lista de municipios asociados al estado
     */
    public Estado(ObjectId id, String nombre, List<Municipio> municipio) {
        this.id = id;
        this.nombre = nombre;
        this.municipio = municipio;
    }

    /**
     * Devuelve el identificador del estado.
     *
     * @return el identificador del estado
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del estado.
     *
     * @param id el identificador del estado
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del estado.
     *
     * @return el nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     *
     * @param nombre el nombre del estado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de municipios asociados al estado.
     *
     * @return la lista de municipios asociados al estado
     */
    public List<Municipio> getMunicipio() {
        return municipio;
    }

    /**
     * Establece la lista de municipios asociados al estado.
     *
     * @param municipio la lista de municipios asociados al estado
     */
    public void setMunicipio(List<Municipio> municipio) {
        this.municipio = municipio;
    }

    /**
     * Devuelve el código hash del estado.
     *
     * @return el código hash del estado
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el estado con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar
     * @return {@code true} si el estado es igual al objeto especificado,
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
        Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una cadena que representa el estado.
     *
     * @return una cadena que representa el estado
     */
    @Override
    public String toString() {
        return "Estado{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", municipio=" + municipio
                + '}';
    }

}
