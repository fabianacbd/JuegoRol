package org.example;

public class Villano extends Personaje {
    public Villano(String nombre, int ataque, int defensa){
        super(nombre, ataque, defensa);
    }

    @Override
    public void atacar(Personaje personaje, int multiplicador) {
        int daño = getAtaque() * multiplicador;
        personaje.recibirDaño(daño);
    }
}
