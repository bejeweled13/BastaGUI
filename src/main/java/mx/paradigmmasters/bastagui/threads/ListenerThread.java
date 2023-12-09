package mx.paradigmmasters.bastagui.threads;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mx.paradigmmasters.bastagui.control.MainControl;
import mx.paradigmmasters.bastagui.model.Constants;
import mx.paradigmmasters.bastagui.model.JsonSerializer;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Hilo que escucha los mensajes entrantes y actualiza el control principal del juego basado en estos mensajes.
 * Deserializa los mensajes JSON entrantes y realiza acciones en la interfaz de usuario y lógica del juego.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class ListenerThread extends Thread{
    private final ObjectInputStream input;
    private final MainControl mainControl;

    /**
     * Constructor que inicializa el hilo con un flujo de entrada y control principal.
     *
     * @param input El flujo de entrada para escuchar los mensajes.
     * @param mainControl El control principal del juego para actualizar la interfaz y la lógica.
     */
    public ListenerThread(ObjectInputStream input, MainControl mainControl) {
        this.input = input;
        this.mainControl = mainControl;
    }

    /**
     * Método que se ejecuta cuando el hilo inicia.
     * Escucha y procesa los mensajes entrantes, actualizando el estado del juego y la interfaz de usuario.
     */
    @Override
    public void run() {
        super.run();
        do {
            try {
                String json = (String) this.input.readObject();

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

                for (String key : jsonObject.keySet()) {
                    switch (key){
                        case "Estado":
                            this.mainControl.setEstadoVista(new JsonSerializer().receiveStatus(jsonObject.getAsJsonObject(key)), new JsonSerializer().receiveTotalPoints(jsonObject.getAsJsonObject(key)));
                            break;
                        case "Calificacion":
                            this.mainControl.setCalificacion(new JsonSerializer().receivePoints(jsonObject.getAsJsonObject(key)));
                            break;
                        case "Letra":
                            this.mainControl.setLetra(new JsonSerializer().receiveLetter(jsonObject.getAsJsonObject(key)));
                            break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } while (this.mainControl.getEstado() != Constants.FINALIZADO);
    }
}
