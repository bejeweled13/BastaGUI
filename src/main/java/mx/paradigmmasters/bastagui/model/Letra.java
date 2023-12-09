package mx.paradigmmasters.bastagui.model;

/**
 * Clase que representa una letra utilizada en el juego.
 * Esta clase almacena una letra y proporciona un método para recuperarla.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class Letra {
    private String letra;

    /**
     * Obtiene la letra almacenada en esta instancia.
     *
     * @return La letra almacenada.
     */
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
