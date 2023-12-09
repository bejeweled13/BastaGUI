package mx.paradigmmasters.bastagui.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Clase que maneja la conexión de red para el juego.
 * Establece una conexión de socket y crea flujos de entrada y salida para la comunicación de red.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class Connection {
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    /**
     * Constructor que inicializa la conexión de red.
     * Establece un socket con el servidor y prepara los flujos de entrada y salida.
     *
     * @throws RuntimeException Si ocurre un error al intentar establecer la conexión o los flujos.
     */
    public Connection() throws RuntimeException{
        try {
            this.socket = new Socket("localhost",5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Obtiene el flujo de salida asociado con la conexión.
     *
     * @return El flujo de salida ({@link ObjectOutputStream}).
     */
    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    /**
     * Obtiene el flujo de entrada asociado con la conexión.
     *
     * @return El flujo de entrada ({@link ObjectInputStream}).
     */
    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }
}
