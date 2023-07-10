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
 * La clase ConexionMongoDB proporciona una conexión a la base de datos MongoDB y devuelve la instancia de la base de datos utilizada por la aplicación.
 *
 * @see MongoClientSettings
 * @see MongoClients
 * @see MongoDatabase
 * @see CodecRegistry
 * @see PojoCodecProvider
 * @author HIRED
 */
public class ConexionMongoDB {

    private static ConexionMongoDB instancia;
    private final String BASE_DATOS = "Findany";
    private final MongoDatabase baseDatos;

    /**
     * Crea una nueva instancia de ConexionMongoDB y establece la conexión a la
     * base de datos MongoDB.
     */
    private ConexionMongoDB() {
        // Convierte clases POJO a documentos en MongoDB
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        // Construye configuraciones del MongoClient
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();

        // Conexión a la base de datos
        MongoClient conexion = MongoClients.create(settings);
        baseDatos = conexion.getDatabase(BASE_DATOS);
    }

    /**
     * Obtiene la instancia única de ConexionMongoDB utilizando el patrón
     * Singleton.
     *
     * @return la instancia única de ConexionMongoDB
     */
    public static ConexionMongoDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMongoDB();
        }
        return instancia;
    }

    /**
     * Obtiene la instancia de la base de datos MongoDB utilizada por la
     * aplicación.
     *
     * @return la instancia de la base de datos MongoDB
     */
    public MongoDatabase getBaseDatos() {
        return baseDatos;
    }

}
