/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author ildex
 */
public class ConexionMongoDB {

    private final String BASE_DATOS = "findany";

    /**
     * Método que obtiene la base de datos.
     *
     * @return La base de datos.
     */
    public MongoDatabase getBaseDatos() {
        //CONVIERTE CLASES POJO A DOCUMENTOS EN MONGODB
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        //CONSTRUYE CONFIGURACIONES DEL MONGOCLIENT
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();

        //CONEXIÓN A LA BASE DE DATOS
        MongoClient conexion = MongoClients.create(settings);
        MongoDatabase baseDatos = conexion.getDatabase(BASE_DATOS);

        return baseDatos;
    }
}
