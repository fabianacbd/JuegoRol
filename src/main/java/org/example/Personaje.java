package org.example;

public class Personaje {
    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = 100;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", salud=" + salud +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }
}
