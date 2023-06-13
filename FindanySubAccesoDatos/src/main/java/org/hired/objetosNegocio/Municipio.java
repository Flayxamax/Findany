package org.hired.objetosNegocio;

import java.util.UUID;

public class Municipio {

    String id, nombre;

    public Municipio(){
    }

    public Municipio(String id, String nombre){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNombre(String nombre){
        return nombre;
    }

    public void setNombre(){
        this.nombre = nombre;
    }

}
