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
 * @author Findany
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
        String patron = "(?!.*\\s{4})[A-Za-z]{1,25}(?:\\s[A-Za-z]{1,25}){0,3}";

        Pattern p = Pattern.compile(patron);

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
        String patron = "(?!.*\\s)[^\\s]{4,20}";

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
        String patron = "(?!.*\\s{2})(?!.*[^a-zA-Z\\s.,])(?=.*[a-zA-Z])[a-zA-Z\\s.,]{1,20}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }
}
