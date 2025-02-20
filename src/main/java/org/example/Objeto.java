package org.example;

public class Objeto {
    private String nombre;
    private String poder;
    private int daño;

    public Objeto(String nombre, String poder, int daño) {
        this.nombre = nombre;
        this.poder = poder;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public String toString() {
        return "Objetos: " + nombre +
                " Poder: " + poder +
                " Daño: " + daño;
    }
}


