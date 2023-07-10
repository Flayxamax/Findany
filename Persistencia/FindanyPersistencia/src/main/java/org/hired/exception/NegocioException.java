/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package org.hired.exception;

/**
 * La clase NegocioException es una excepción personalizada utilizada en el contexto del negocio.
 * @author HIRED
 */
public class NegocioException extends Exception {

    /**
     * Crea una instancia de NegocioException sin mensaje de detalle.
     */
    public NegocioException() {
    }

    /**
     * Crea una instancia de NegocioException con un mensaje de detalle.
     *
     * @param message el mensaje de detalle
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Crea una instancia de NegocioException con un mensaje de detalle y una causa subyacente.
     *
     * @param message el mensaje de detalle
     * @param cause la causa subyacente de la excepción
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una instancia de NegocioException con una causa subyacente.
     *
     * @param cause la causa subyacente de la excepción
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una instancia de NegocioException con un mensaje de detalle, una causa subyacente, y opciones para habilitar la supresión y escribir la traza de la pila.
     *
     * @param message el mensaje de detalle
     * @param cause la causa subyacente de la excepción
     * @param enableSuppression indica si se habilita la supresión de excepciones
     * @param writableStackTrace indica si se escribe la traza de la pila
     */
    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
