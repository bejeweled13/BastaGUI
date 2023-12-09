package mx.paradigmmasters.bastagui.model;

/**
 * Clase que representa el estado actual del juego y la puntuación del jugador.
 * Mantiene información sobre el estado del juego utilizando constantes definidas en {@link Constants}.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class Estado {
    private int estado = Constants.CARGANDO;
    private int puntos = 0;

    /**
     * Obtiene el estado actual del juego.
     *
     * @return El estado del juego, utilizando las constantes definidas en {@link Constants}.
     */
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la puntuación actual del jugador.
     *
     * @return La puntuación actual del jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
