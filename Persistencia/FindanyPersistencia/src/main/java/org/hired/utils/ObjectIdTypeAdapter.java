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

public class ObjectIdTypeAdapter extends TypeAdapter<ObjectId> {

    @Override
    public void write(JsonWriter out, ObjectId value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toHexString());
        }
    }

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
