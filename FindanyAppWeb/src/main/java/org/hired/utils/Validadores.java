/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ildex
 */
public class Validadores {

    /**
     * Método que valida que el nombre contenga de 3 a 40 caracteres, siendo
     * estos: letras, espacios y guiones.
     *
     * @param s Cadena de texto.
     * @return coincidencia entre los validadores y la cadena de texto.
     */
    public boolean esNombre(String s) {
        String patron = "(([a-z]|[A-Z])|([ '-]([a-z]|[A-Z]))){3,40}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    /**
     * Método que valida que el teléfono contenga de 1 a 10 caracteres, siendo
     * estos números.
     *
     * @param s Cadena de texto.
     * @return coincidencia entre los validadores y la cadena de texto.
     */
    public boolean esTelefono(String s) {
        String patron = "([0-9]){1,10}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }
}
