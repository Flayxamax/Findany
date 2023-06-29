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

    private static ConexionMongoDB instancia;
    private final String BASE_DATOS = "Findany";
    private final MongoDatabase baseDatos;

    private ConexionMongoDB() {
        //CONVIERTE CLASES POJO A DOCUMENTOS EN MONGODB
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        //CONSTRUYE CONFIGURACIONES DEL MONGOCLIENT
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();

        //CONEXIÓN A LA BASE DE DATOS
        MongoClient conexion = MongoClients.create(settings);
        baseDatos = conexion.getDatabase(BASE_DATOS);
    }

    public static ConexionMongoDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMongoDB();
        }
        return instancia;
    }

    public MongoDatabase getBaseDatos() {
        return baseDatos;
    }
}
