/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package org.hired.exception;

/**
 * La clase PersistenciaException es una excepción personalizada utilizada en el contexto de la persistencia de datos.
 *
 * @author HIRED
 */
public class PersistenciaException extends Exception {

    /**
     * Crea una instancia de PersistenciaException sin mensaje de detalle.
     */
    public PersistenciaException() {
    }

    /**
     * Crea una instancia de PersistenciaException con un mensaje de detalle.
     *
     * @param message el mensaje de detalle
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una instancia de PersistenciaException con un mensaje de detalle y una causa subyacente.
     *
     * @param message el mensaje de detalle
     * @param cause la causa subyacente de la excepción
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una instancia de PersistenciaException con una causa subyacente.
     *
     * @param cause la causa subyacente de la excepción
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una instancia de PersistenciaException con un mensaje de detalle, una causa subyacente, y opciones para habilitar la supresión y escribir la traza de la pila.
     *
     * @param message el mensaje de detalle
     * @param cause la causa subyacente de la excepción
     * @param enableSuppression indica si se habilita la supresión de excepciones
     * @param writableStackTrace indica si se escribe la traza de la pila
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
