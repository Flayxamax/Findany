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
 * La clase Usuario representa a un usuario en el sistema.
 *
 * @author HIRED
 */
public class Usuario {

    private ObjectId id;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private Binary avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private Genero genero;
    private Municipio municipio;
    private TipoUsuario tipo;

    /**
     * Crea una instancia vacía de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Crea una instancia de la clase Usuario con los datos especificados.
     *
     * @param nombreCompleto el nombre completo del usuario
     * @param correo el correo electrónico del usuario
     * @param contrasena la contraseña del usuario
     * @param telefono el número de teléfono del usuario
     * @param avatar la imagen de avatar del usuario
     * @param ciudad la ciudad del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param genero el género del usuario
     * @param municipio el municipio del usuario
     * @param tipo el tipo de usuario
     */
    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, Binary avatar, String ciudad, Date fechaNacimiento, Genero genero, Municipio municipio, TipoUsuario tipo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
        this.tipo = tipo;
    }

    /**
     * Crea una instancia de la clase Usuario con los datos especificados.
     *
     * @param id el id del usuario
     * @param nombreCompleto el nombre completo del usuario
     * @param correo el correo electrónico del usuario
     * @param contrasena la contraseña del usuario
     * @param telefono el número de teléfono del usuario
     * @param avatar la imagen de avatar del usuario
     * @param ciudad la ciudad del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param genero el género del usuario
     * @param municipio el municipio del usuario
     * @param tipo el tipo de usuario
     */
    public Usuario(ObjectId id, String nombreCompleto, String correo, String contrasena, String telefono, Binary avatar, String ciudad, Date fechaNacimiento, Genero genero, Municipio municipio, TipoUsuario tipo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
        this.tipo = tipo;
    }

    /**
     * Devuelve el identificador del usuario.
     *
     * @return el identificador del usuario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id el identificador del usuario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre completo del usuario.
     *
     * @return el nombre completo del usuario
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto el nombre completo del usuario
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo el correo electrónico del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena la contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono el número de teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la imagen de avatar del usuario.
     *
     * @return la imagen de avatar del usuario
     */
    public Binary getAvatar() {
        return avatar;
    }

    /**
     * Establece la imagen de avatar del usuario.
     *
     * @param avatar la imagen de avatar del usuario
     */
    public void setAvatar(Binary avatar) {
        this.avatar = avatar;
    }

    /**
     * Devuelve la ciudad del usuario.
     *
     * @return la ciudad del usuario
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del usuario.
     *
     * @param ciudad la ciudad del usuario
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve la fecha de nacimiento del usuario.
     *
     * @return la fecha de nacimiento del usuario
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento la fecha de nacimiento del usuario
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el género del usuario.
     *
     * @return el género del usuario
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero el género del usuario
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Devuelve elmunicipio del usuario.
     *
     * @return el municipio del usuario
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio del usuario.
     *
     * @param municipio el municipio del usuario
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Devuelve el tipo de usuario.
     *
     * @return el tipo de usuario
     */
    public TipoUsuario getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipo el tipo de usuario
     */
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    /**
     * Calcula el hash code del usuario.
     *
     * @return el hash code del usuario
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara el usuario actual con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar
     * @return true si el usuario y el objeto son iguales, false en caso
     * contrario
     */
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en forma de cadena del usuario.
     *
     * @return una cadena que representa el usuario
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasena=" + contrasena + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", municipio=" + municipio + ", tipo=" + tipo + '}';
    }

}
