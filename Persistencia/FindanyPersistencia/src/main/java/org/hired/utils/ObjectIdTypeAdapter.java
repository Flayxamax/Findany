/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.bson.types.ObjectId;
import java.io.IOException;

/**
 * La clase ObjectIdTypeAdapter es un adaptador de tipo personalizado utilizado
 * para serializar y deserializar objetos ObjectId de la biblioteca BSON de
 * MongoDB en formato JSON.
 * 
 * @author HIRED
 */
public class ObjectIdTypeAdapter extends TypeAdapter<ObjectId> {

    /**
     * Escribe el valor del ObjectId en formato JSON.
     *
     * @param out el escritor JSON
     * @param value el ObjectId a escribir
     * @throws IOException si ocurre un error de E/S durante la escritura
     */
    @Override
    public void write(JsonWriter out, ObjectId value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toHexString());
        }
    }

    /**
     * Lee y deserializa un valor de ObjectId a partir de un lector JSON.
     *
     * @param in el lector JSON
     * @return el ObjectId leído y deserializado
     * @throws IOException si ocurre un error de E/S durante la lectura
     */
    @Override
    public ObjectId read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            String objectIdString = in.nextString();
            return new ObjectId(objectIdString);
        }
    }
}
