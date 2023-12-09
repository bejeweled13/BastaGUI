package mx.paradigmmasters.bastagui.model;

/**
 * Clase que representa la calificación obtenida en diferentes categorías del juego.
 * Almacena las puntuaciones para las categorías de nombre, flor o fruto, país, animal y color.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class Calificacion {
    private int nombre, florFruto, pais, animal, color;

    /**
     * Constructor por defecto.
     */
    public Calificacion() {
    }

    /**
     * Obtiene la puntuación para la categoría 'nombre'.
     *
     * @return Puntuación para la categoría 'nombre'.
     */
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la puntuación para la categoría 'flor o fruto'.
     *
     * @return Puntuación para la categoría 'flor o fruto'.
     */
    public int getFlorFruto() {
        return florFruto;
    }

    public void setFlorFruto(int florFruto) {
        this.florFruto = florFruto;
    }

    /**
     * Obtiene la puntuación para la categoría 'país'.
     *
     * @return Puntuación para la categoría 'país'.
     */
    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la puntuación para la categoría 'animal'.
     *
     * @return Puntuación para la categoría 'animal'.
     */
    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    /**
     * Obtiene la puntuación para la categoría 'color'.
     *
     * @return Puntuación para la categoría 'color'.
     */
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
