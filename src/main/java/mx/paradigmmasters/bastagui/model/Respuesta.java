package mx.paradigmmasters.bastagui.model;

public class Respuesta {
    private String nombre, florFruto, pais, animal, color;

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
