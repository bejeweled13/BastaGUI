package mx.paradigmmasters.bastagui.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Clase de utilidad para la serialización y deserialización de objetos utilizando Gson.
 * Proporciona métodos para convertir objetos Java en representaciones JSON y viceversa.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class JsonSerializer {

    /**
     * Constructor por defecto.
     */
    public JsonSerializer() {
    }

    /**
     * Deserializa un objeto JSON a un objeto {@link Estado} y obtiene su estado.
     *
     * @param json El objeto JSON a deserializar.
     * @return El estado obtenido del objeto {@link Estado}.
     */
    public int receiveStatus(JsonObject json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        System.out.println(gson.fromJson(json, Estado.class).getEstado());

        return gson.fromJson(json, Estado.class).getEstado();
    }

    /**
     * Deserializa un objeto JSON a un objeto {@link Estado} y obtiene sus puntos totales.
     *
     * @param json El objeto JSON a deserializar.
     * @return Los puntos totales obtenidos del objeto {@link Estado}.
     */
    public int receiveTotalPoints(JsonObject json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        System.out.println(gson.fromJson(json,Estado.class).getPuntos());

        return gson.fromJson(json, Estado.class).getPuntos();
    }

    /**
     * Serializa un objeto {@link Respuesta} a una representación JSON.
     *
     * @param answers El objeto {@link Respuesta} a serializar.
     * @return Una cadena JSON que representa el objeto {@link Respuesta}.
     */
    public String sendAnswers(Respuesta answers){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        return gson.toJson(answers);
    }

    /**
     * Deserializa un objeto JSON a un objeto {@link Calificacion}.
     *
     * @param json El objeto JSON a deserializar.
     * @return El objeto {@link Calificacion} deserializado.
     */
    public Calificacion receivePoints(JsonObject json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, Calificacion.class);
    }

    /**
     * Deserializa un objeto JSON a un objeto {@link Letra} y obtiene su letra.
     *
     * @param json El objeto JSON a deserializar.
     * @return La letra obtenida del objeto {@link Letra}.
     */
    public String receiveLetter(JsonObject json){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, Letra.class).getLetra();
    }
}
