/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase utilizada para validar textos de entrada
 *
 * @author HIRED
 */
public class Validadores {

    /**
     * Verifica si una cadena cumple con el patrón de un nombre.
     *
     * @param s la cadena a verificar
     * @return true si la cadena cumple con el patrón de nombre, false en caso
     * contrario
     */
    public boolean esNombre(String s) {
        String patron = "(?!.*\\s{4})[\\p{L}]{1,25}(?:\\s[\\p{L}]{1,25}){0,3}";

        Pattern p = Pattern.compile(patron, Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena cumple con el patrón de un correo electrónico.
     *
     * @param s la cadena a verificar
     * @return true si la cadena cumple con el patrón de correo electrónico,
     * false en caso contrario
     */
    public boolean esCorreo(String s) {
        String patron = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena cumple con el patrón de una contraseña.
     *
     * @param s la cadena a verificar
     * @return true si la cadena cumple con el patrón de contraseña, false en
     * caso contrario
     */
    public boolean esContrasena(String s) {
        String patron = "(?!.*\\s)[^\\s\\p{M}]{4,20}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena cumple con el patrón de un número de teléfono.
     *
     * @param s la cadena a verificar
     * @return true si la cadena cumple con el patrón de número de teléfono,
     * false en caso contrario
     */
    public boolean esTelefono(String s) {
        String patron = "^\\+\\d{1,3}\\d{10}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena cumple con el patrón de una ciudad.
     *
     * @param s la cadena a verificar
     * @return true si la cadena cumple con el patrón de ciudad, false en caso
     * contrario
     */
    public boolean esCiudad(String s) {
        String patron = "(?!.*\\s{2})(?!.*[^a-zA-Z\\s.,áéíóúÁÉÍÓÚ])(?=.*[a-zA-ZáéíóúÁÉÍÓÚ])[a-zA-ZáéíóúÁÉÍÓÚ\\s.,]{1,20}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena de texto cumple con los requisitos de formato para
     * un título.
     *
     * @param s la cadena de texto a verificar
     * @return true si la cadena de texto cumple con los requisitos de formato
     * para un título, false de lo contrario
     */
    public boolean esTitulo(String s) {
        String patron = "^[\\p{L}\\p{M}\\s]{1,20}$";

        Pattern p = Pattern.compile(patron, Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena de texto cumple con los requisitos de formato para
     * un contenido.
     *
     * @param s la cadena de texto a verificar
     * @return true si la cadena de texto cumple con los requisitos de formato
     * para un contenido, false de lo contrario
     */
    public boolean esContenido(String s) {
        String patron = "^[\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}]{1,200}$";

        Pattern p = Pattern.compile(patron, Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Verifica si una cadena de texto cumple con los requisitos de formato para
     * un contenido de comentario.
     *
     * @param s la cadena de texto a verificar
     * @return true si la cadena de texto cumple con los requisitos de formato
     * para un contenido de comentario, false de lo contrario
     */
    public boolean esContenidoComentario(String s) {
        String patron = "^[\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}]{1,100}$";

        Pattern p = Pattern.compile(patron, Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

}
