package org.example;

public class Combate {
    private Superheroe[] superheroes;
    private Villano[] villanos;
    private Objeto[] objetos;

    public Combate() {
        this.superheroes = crearArraySuperheroes();
        this.villanos = crearArrayVillanos();
        this.objetos = crearArrayObjeto();
    }


    private Superheroe[] crearArraySuperheroes(){
        //Creacion de los superheroes
        Superheroe mario = new Superheroe("Mario", 10, 10);
        Superheroe luigi = new Superheroe("Luigi", 10, 9);
        //Creación de objeto con el polimorfismo
        Superheroe peach = new Superheroe("Princesa Peach", 8, 5);
        Superheroe yoshi = new Superheroe("Yoshi", 8, 10);
        Superheroe toad = new Superheroe("Toad", 7, 7);
        //Creacion de array de superheroes
        Superheroe[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private Villano[] crearArrayVillanos() {
        //Creacion de villanos
        Villano browser = new Villano("Browser", 10, 9);
        Villano wario = new Villano("Wario", 9, 9);
        //Creacion de objeto con el polimorfismo
        Villano waluigi = new Villano("Waluigi", 8, 8);
        Villano donkeykong = new Villano("Donkey Kong", 10, 10);
        Villano reyboo = new Villano("Rey Boo", 9, 8);

        //Creacion de array de villanos
        Villano[] villanos = {browser, waluigi, wario, donkeykong, reyboo};
        return villanos;
    }

    private Objeto[] crearArrayObjeto() {
        //Creacion de objetos
        Objeto champiñonRojo = new Objeto("Champiñon rojo", "Te hace mas grande", 10);
        Objeto florDeFuego = new Objeto("Flor de fuego", "Poder de lanzar bolas de fuego", 10);
        Objeto florDeHielo = new Objeto("Flor de hielo", "Poder de lanzar bolas de hielo", 10);
        //Creacion de objetos con el polimorfismo
        Objeto estrella = new Objeto("Estrella", "Te vuelve invensible por 20 segundos", 10);
        Objeto champiñonVerde = new Objeto("Champiñon verde", "Te llena la salud", 10);

        //Creacion de array de villanos
        Objeto[] objetos = {champiñonRojo, champiñonVerde, florDeFuego, florDeHielo, estrella};
        return objetos;
    }

    public void imprimirArray(Personaje[] personajes) {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }


    public void imprimirArrayObjetos(Objeto[] objetos) {
        for (Objeto o : objetos) {
            System.out.println(o);
        }
    }

    public Superheroe escogerSuperheroe(Superheroe[] superheroes, int opcion){
        return superheroes[opcion - 1];
    }

    public Villano escogerVillanos(Villano[] villanos, int opcion){
        return villanos[opcion - 1];
    }

    public Objeto escogerObjeto(Objeto[] objetos, int opcion){
        return objetos[opcion - 1];
    }

    public boolean comprobarOpcionPersonajes(Personaje[] personajes, int opcion){
        if (opcion > 0 && opcion < personajes.length){
            return true;
        }
        return false;
    }

    public boolean comprobarOpcionObjetos(Objeto[] objetos, int opcion){
        if (opcion > 0 && opcion < objetos.length){
            return true;
        }
        return false;
    }


    public void luchaPersonajes(Superheroe superheroeEscogido, Villano villanoEscogido, Objeto objeto) {
        System.out.println("La lucha ha comenzado!");
        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
        System.out.println("El objeto escogido para tu superheroe sera: " + objeto.getNombre() + ". Poder: " + objeto.getPoder() + ". Daño: " + objeto.getDaño());
        System.out.println("Tu villano sera " + villanoEscogido.getNombre());
        //función turno personaje1
        //función turno personaje2
    }

    public Superheroe[] getSuperheroes() {
        return superheroes;
    }

    public Villano[] getVillanos() {
        return villanos;
    }

    public Objeto[] getObjetos() {
        return objetos;
    }
}

