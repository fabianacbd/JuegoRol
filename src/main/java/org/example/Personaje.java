package org.example;

public abstract class Personaje {
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

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    @Override
    public String toString() {
        return  nombre +
                ", salud ❤\uFE0F " + salud +
                ", ataque \uD83D\uDCA5 " + ataque +
                ", defensa \uD83D\uDEE1\uFE0F " + defensa;
    }

    public abstract void atacar(Personaje personaje, int multiplicador);

    public void recibirDaño(int daño){
        this.salud = salud - (daño - this.defensa);
        if (salud < 0){
            this.salud = 0;
        }
    }


}
