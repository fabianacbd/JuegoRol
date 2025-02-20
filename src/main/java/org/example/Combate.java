package org.example;

import java.util.Scanner;

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
        Superheroe mario = new Superheroe("Mario", 10, 8);
        Superheroe luigi = new Superheroe("Luigi", 10, 7);
        //Creación de objeto con el polimorfismo
        Superheroe peach = new Superheroe("Princesa Peach", 8, 5);
        Superheroe yoshi = new Superheroe("Yoshi", 8, 6);
        Superheroe toad = new Superheroe("Toad", 7, 5);
        //Creacion de array de superheroes
        Superheroe[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private Villano[] crearArrayVillanos() {
        //Creacion de villanos
        Villano browser = new Villano("Browser", 10, 9);
        Villano wario = new Villano("Wario", 9, 7);
        //Creacion de objeto con el polimorfismo
        Villano waluigi = new Villano("Waluigi", 8, 6);
        Villano donkeykong = new Villano("Donkey Kong", 10, 8);
        Villano reyboo = new Villano("Rey Boo", 9, 6);

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
        Objeto estrella = new Objeto("Estrella", "Te vuelve super rapido", 10);
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
        if (opcion > 0 && opcion < personajes.length + 1){
            return true;
        }
        return false;
    }

    public boolean comprobarOpcionObjetos(Objeto[] objetos, int opcion){
        if (opcion > 0 && opcion < objetos.length + 1){
            return true;
        }
        return false;
    }

    public void luchaPersonajes(Superheroe superheroeEscogido, Villano villanoEscogido, Objeto objeto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("¡LA BATALLA HA EMPEZADO!");
        System.out.println("-------------------------------");
        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
        System.out.println("El objeto escogido para tu superheroe sera: " + objeto.getNombre() + ". Poder: " + objeto.getPoder() + ". Daño: " + objeto.getDaño());
        System.out.println("Tu villano sera " + villanoEscogido.getNombre());
        while (superheroeEscogido.getSalud() > 0 && villanoEscogido.getSalud() > 0) {
            // Turno del superhéroe
            System.out.println("Es turno de " + superheroeEscogido.getNombre());
            System.out.println("Presiona 1 para atacar o 2 para saltar y aplastar");
            int turnoAtaqueSuperheroe = scanner.nextInt(); //COMPROBAR QUE SE COLOQUE 1 O 2
            if(turnoAtaqueSuperheroe == 1 || turnoAtaqueSuperheroe == 2) {
                int dañoInfringidoSuperheroe = (superheroeEscogido.getAtaque() + objeto.getDaño()) - villanoEscogido.getDefensa();
                if (turnoAtaqueSuperheroe == 1) {
                    villanoEscogido.setSalud(Math.max(0, villanoEscogido.getSalud() - dañoInfringidoSuperheroe));
                    System.out.println(superheroeEscogido.getNombre() + " ha atacado a " + villanoEscogido.getNombre());
                    System.out.println("Salud: " + villanoEscogido.getSalud());
                } else {
                    villanoEscogido.setSalud(Math.max(0, villanoEscogido.getSalud() - dañoInfringidoSuperheroe * 2));
                    System.out.println(superheroeEscogido.getNombre() + " ha aplastado a " + villanoEscogido.getNombre());
                    System.out.println("Salud: " + villanoEscogido.getSalud());
                }
                // Si el villano murió, terminamos el bucle
                if (villanoEscogido.getSalud() <= 0) {
                    System.out.println(villanoEscogido.getNombre() + " HA SIDO DERROTADO.");
                    break;
                } else {
                    // Turno del villano
                    System.out.println("Es turno de " + villanoEscogido.getNombre());
                    System.out.println("Presiona 1 para atacar o 2 para superataque");
                    int turnoAtaqueVillano = scanner.nextInt();
                    int dañoInfringidoVillano = villanoEscogido.getAtaque() - superheroeEscogido.getDefensa();
                    if (turnoAtaqueVillano == 1) {
                        superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano));
                        System.out.println(villanoEscogido.getNombre() + " ha atacado a " + superheroeEscogido.getNombre());
                        System.out.println("Salud: " + superheroeEscogido.getSalud());
                    } else {
                        superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano * 2));
                        System.out.println(villanoEscogido.getNombre() + " ha hecho superataque a " + superheroeEscogido.getNombre());
                        System.out.println("Salud: " + superheroeEscogido.getSalud());

                    }

                    // Si el superhéroe murió, terminamos el bucle
                    if (superheroeEscogido.getSalud() <= 0) {
                        System.out.println(superheroeEscogido.getNombre() + " HA SIDO DERROTADO.");
                        break;
                    }
                }
            } else {
                System.out.println("Valor introducido incorrecto.");
            }
        }

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

