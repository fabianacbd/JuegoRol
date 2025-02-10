package org.example;

public class Ataque {
    private String tipo;
    private int daño;

    public Ataque(String tipo, int daño) {
        this.tipo = tipo;
        this.daño = daño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "tipo='" + tipo + '\'' +
                ", daño=" + daño +
                '}';
    }
}
