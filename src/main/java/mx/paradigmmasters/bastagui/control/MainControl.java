package mx.paradigmmasters.bastagui.control;

import mx.paradigmmasters.bastagui.model.*;
import mx.paradigmmasters.bastagui.threads.ListenerThread;
import mx.paradigmmasters.bastagui.view.GameView;
import mx.paradigmmasters.bastagui.view.JoinView;

import java.io.IOException;
/**
 * Controlador principal del juego Basta.
 * Esta clase maneja la lógica de inicio y conexión del juego, así como la actualización de la interfaz de usuario.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class MainControl {
    private JoinView joinView;
    private GameView gameView;
    private Connection connection;
    private int connectionAttempts;
    private int estado = Constants.CARGANDO;

    /**
     * Constructor para inicializar la vista de unión (JoinView).
     */
    public MainControl() {
        this.joinView = new JoinView(this);
    }

    /**
     * Obtiene el estado actual del juego.
     *
     * @return el estado del juego.
     */
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Inicia el juego estableciendo la conexión y preparando la interfaz de usuario.
     *
     * @param userName El nombre de usuario para el juego.
     */
    public void startGame(String userName){
        boolean isConnected = false;
        this.connectionAttempts = 3;
        do {
            isConnected = tryConnection();
            this.connectionAttempts--;
        }while (!isConnected);

        try {
            this.connection.getOutput().writeObject(userName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.gameView = new GameView(this);
        this.joinView.setVisible(false);

        ListenerThread listenerThread = new ListenerThread(this.connection.getInput(), this);
        listenerThread.start();

    }

    /**
     * Intenta establecer una conexión con el servidor del juego.
     *
     * @return Verdadero si la conexión es exitosa, falso en caso contrario.
     */
    public boolean tryConnection(){
        try {
            this.connection = new Connection();
            this.connectionAttempts = 3;
            return true;
        }catch (RuntimeException e) {
            if (this.connectionAttempts == 0){
                throw new RuntimeException(e);
            }else {
                this.joinView.connectionError(this.connectionAttempts);
            }
            return false;
        }
    }

    /**
     * Establece el estado del juego y actualiza la interfaz de usuario con el estado y puntos actuales.
     *
     * @param estado El nuevo estado del juego.
     * @param puntos La cantidad de puntos acumulados.
     */
    public void setEstadoVista(int estado, int puntos){
        this.estado = estado;
        this.gameView.setStatus(estado);
        this.gameView.setTotalPoints(puntos);
    }

    /**
     * Establece la letra actual en la vista del juego.
     *
     * @param letter La letra a mostrar en la interfaz de usuario.
     */
    public void setLetra(String letter){
        this.gameView.setLetter(letter);
    }

    /**
     * Actualiza la calificación en la vista del juego.
     *
     * @param calificacion Objeto de tipo Calificacion con los datos a mostrar.
     */
    public void setCalificacion(Calificacion calificacion){
        this.gameView.setCalificacion(
                calificacion.getNombre(),
                calificacion.getFlorFruto(),
                calificacion.getPais(),
                calificacion.getAnimal(),
                calificacion.getColor()
        );
    }

    /**
     * Envía las respuestas del jugador al servidor.
     *
     * @param nombre El nombre propuesto por el jugador.
     * @param florFruto La flor o fruto propuesto por el jugador.
     * @param pais El país propuesto por el jugador.
     * @param animal El animal propuesto por el jugador.
     * @param color El color propuesto por el jugador.
     * @throws IOException Si ocurre un error al enviar las respuestas.
     */
    public void sendAnswers(
            String nombre,
            String florFruto,
            String pais,
            String animal,
            String color
    ) throws IOException {
        this.connection.getOutput().writeObject(new JsonSerializer().sendAnswers(new Respuesta(nombre, florFruto, pais, animal, color)));
    }
}
