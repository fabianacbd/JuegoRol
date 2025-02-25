package org.example;

public class Superheroe extends Personaje {
    private Objeto objeto;


    public Superheroe(String nombre, int ataque, int defensa){
        super(nombre, ataque, defensa);
        this.objeto = null;

    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    @Override
    public void atacar(Personaje personaje, int multiplicador) {
        int daño = (this.getAtaque() + this.getObjeto().getDaño()) * multiplicador;
        personaje.recibirDaño(daño);
    }
}
