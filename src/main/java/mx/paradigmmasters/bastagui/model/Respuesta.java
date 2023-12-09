package mx.paradigmmasters.bastagui.model;

/**
 * Clase que representa las respuestas de un jugador en el juego.
 * Almacena respuestas en diferentes categorías como nombre, flor o fruto, país, animal y color.
 *
 * @author García Martínez María Fernanda
 * @author Hernández Meza Víctor Yahir
 * @author Márquez López María Fernanda
 * @author Martínez Florez Uri
 */
public class Respuesta {
    private String nombre, florFruto, pais, animal, color;

    /**
     * Constructor que inicializa una nueva instancia de Respuesta con valores específicos para cada categoría.
     *
     * @param nombre El nombre propuesto por el jugador.
     * @param florFruto La flor o fruto propuesto por el jugador.
     * @param pais El país propuesto por el jugador.
     * @param animal El animal propuesto por el jugador.
     * @param color El color propuesto por el jugador.
     */
    public Respuesta(String nombre, String florFruto, String pais, String animal, String color) {
        this.nombre = nombre;
        this.florFruto = florFruto;
        this.pais = pais;
        this.animal = animal;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFlorFruto() {
        return florFruto;
    }

    public void setFlorFruto(String florFruto) {
        this.florFruto = florFruto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
