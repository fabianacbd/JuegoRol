package org.example;

import java.util.Scanner;
import java.util.Random;

public class Combate {
    private Superheroe[] superheroes;
    private Villano[] villanos;
    private Objeto[] objetos;
    private Scanner scanner;

    public Combate() {
        this.superheroes = crearArraySuperheroes();
        this.villanos = crearArrayVillanos();
        this.objetos = crearArrayObjeto();
        this.scanner = new Scanner(System.in);
    }


    private Superheroe[] crearArraySuperheroes(){
        //Creacion de los superheroes
        Superheroe mario = new Superheroe("Mario \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDD27\uD83D\uDD34", 8, 7);
        Superheroe luigi = new Superheroe("Luigi \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDD27\uD83D\uDFE2", 7, 6);
        //Creación de objeto con el polimorfismo
        Superheroe peach = new Superheroe("Princesa Peach \uD83D\uDC78\uD83C\uDFFC", 4, 3);
        Superheroe yoshi = new Superheroe("Yoshi \uD83E\uDD96", 6, 5);
        Superheroe toad = new Superheroe("Toad \uD83C\uDF44\u200D\uD83D\uDFEB", 5, 4);
        //Creacion de array de superheroes
        Superheroe[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private Villano[] crearArrayVillanos() {
        //Creacion de villanos
        Villano browser = new Villano("Browser \uD83D\uDC32", 10, 9);
        Villano wario = new Villano("Wario \uD83D\uDC77\uD83C\uDFFB", 7, 7);
        //Creacion de objeto con el polimorfismo
        Villano waluigi = new Villano("Waluigi \uD83E\uDDB9\uD83C\uDFFB\u200D♂\uFE0F", 7, 6);
        Villano donkeykong = new Villano("Donkey Kong \uD83E\uDD8D", 8, 8);
        Villano reyboo = new Villano("Rey Boo \uD83D\uDC7B", 7, 5);

        //Creacion de array de villanos
        Villano[] villanos = {browser, waluigi, wario, donkeykong, reyboo};
        return villanos;
    }

    private Objeto[] crearArrayObjeto() {
        //Creacion de objetos
        Objeto champiñonRojo = new Objeto("Champiñon Rojo \uD83C\uDF44", "Te hace mas grande. ", 6);
        Objeto florDeFuego = new Objeto("Flor de fuego \uD83D\uDD25", "Lanzar bolas de fuego. ", 8);
        Objeto florDeHielo = new Objeto("Flor de hielo ❄\uFE0F", "Lanzar bolas de hielo. ", 8);
        //Creacion de objetos con el polimorfismo
        Objeto estrella = new Objeto("Estrella ⭐", "Te vuelve invencible. ", 10);

        //Creacion de array de villanos
        Objeto[] objetos = {champiñonRojo, florDeFuego, florDeHielo, estrella};
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
        System.out.println("-------------------------------");
        System.out.println("¡LA BATALLA HA EMPEZADO!");
        System.out.println("-------------------------------");
        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
        superheroeEscogido.setObjeto(objeto);
        System.out.println("El objeto escogido para tu superheroe sera: " + superheroeEscogido.getObjeto());
        System.out.println("Tu villano sera " + villanoEscogido.getNombre());
        while (superheroeEscogido.getSalud() > 0 && villanoEscogido.getSalud() > 0) {
            turnoSuperheroe(superheroeEscogido, villanoEscogido);
            turnoVillano(villanoEscogido, superheroeEscogido);
        }
        if (superheroeEscogido.getSalud() <= 0) {
            System.out.println("-------------------------------");
            System.out.println("¡LA BATALLA HA TERMINADO!");
            System.out.println("-------------------------------");
            System.out.println(superheroeEscogido.getNombre() + " HA SIDO DERROTADO.");
            System.out.println(villanoEscogido.getNombre() + " ES EL GANADOR.");
        }
         if (villanoEscogido.getSalud() <= 0) {
            System.out.println("-------------------------------");
            System.out.println("¡LA BATALLA HA TERMINADO!");
            System.out.println("-------------------------------");
            System.out.println(villanoEscogido.getNombre() + " HA SIDO DERROTADO.");
            System.out.println(superheroeEscogido.getNombre() + " ES EL GANADOR.");
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

    private void turnoSuperheroe(Superheroe superheroe, Villano villano){
        // Turno del superhéroe
        System.out.println("-------------------------------");
        System.out.println("Es turno de " + superheroe.getNombre());
        System.out.println("-------------------------------");
        System.out.println("Presiona:");
        System.out.println("1) Atacar 2) Saltar y aplastar 3) Curarte con Champiñon Verde");
        boolean puedeCurarse = true;
        int turnoAtaqueSuperheroe = scanner.nextInt();

        if (turnoAtaqueSuperheroe == 1) {
            superheroe.atacar(villano, 1);
            switch (superheroe.getObjeto().getNombre()){
                case "Champiñon Rojo \uD83C\uDF44" -> {
                    System.out.println(superheroe.getNombre() + " se ha hecho más grande \uD83C\uDF44 y ataca a " + villano.getNombre());
                    System.out.println("La salud de " + villano.getNombre() + " ahora es de " + villano.getSalud());
                }
                case "Flor de fuego \uD83D\uDD25" -> {
                    System.out.println(superheroe.getNombre() + " ha lanzado bolas de fuego \uD83D\uDD25 a " + villano.getNombre());
                    System.out.println("La salud de " + villano.getNombre() + " ahora es de " + villano.getSalud());
                }
                case "Flor de hielo ❄\uFE0F" -> {
                    System.out.println(superheroe.getNombre() + " ha lanzado bolas de hielo ❄\uFE0F a " + villano.getNombre());
                    System.out.println("La salud de " + villano.getNombre() + " ahora es de " + villano.getSalud());
                }
                case "Estrella ⭐" -> {
                    villano.setSalud(0);
                    System.out.println(superheroe.getNombre() + " tiene el poder de la estrella ⭐ y ha derrotado de un golpe a " + villano.getNombre());
                    System.out.println(villano.getNombre() + " HA SIDO DERROTADO.");
                }
            }
        } else if (turnoAtaqueSuperheroe == 2) {
            superheroe.atacar(villano, 2);
            System.out.println(superheroe.getNombre() + " ha dado un doble salto y ha aplastado a " + villano.getNombre());
            System.out.println("La salud de " + villano.getNombre() + " ahora es de " + villano.getSalud());
        } else if (turnoAtaqueSuperheroe == 3 && puedeCurarse){
            superheroe.setSalud(100);
            System.out.println(superheroe.getNombre() + " ha usado el champiñon verde y se ha curado");
            System.out.println("El nivel de la salud de " + superheroe.getNombre() + " es de " + superheroe.getSalud());
            puedeCurarse = false;
        } else {
            System.out.println("Opcion no valida.");
        }

    }

    private void turnoVillano(Villano villano, Superheroe superheroe){
        // Turno del villano
        System.out.println("-------------------------------");
        System.out.println("Es turno de " + villano.getNombre());
        System.out.println("-------------------------------");
        System.out.println("Presiona:");
        System.out.println("1) Atacar 2) Superataque 3) Curarte con pocion magica \uD83D\uDD2E");
        boolean puedeCurarse = true;
        int turnoAtaqueVillano = scanner.nextInt();

        if (turnoAtaqueVillano == 1) {
            villano.atacar(superheroe, 1);
            System.out.println(villano.getNombre() + " ha atacado a " + superheroe.getNombre());
            System.out.println("La salud de " + superheroe.getNombre() + " ahora es de " + superheroe.getSalud());

        } else if (turnoAtaqueVillano == 2) {
            villano.atacar(superheroe, 3);
            System.out.println(villano.getNombre() + " ha hecho superataque \uD83D\uDD25 a " + superheroe.getNombre());
            System.out.println("La salud de " + superheroe.getNombre() + " ahora es de " + superheroe.getSalud());
        } else if (turnoAtaqueVillano == 3) {
            if (puedeCurarse) {
                villano.setSalud(100);
                System.out.println(villano.getNombre() + " ha usado la pocion curativa \uD83D\uDD2E y se ha curado");
                System.out.println("El nivel de la salud de " + villano.getNombre() + " es de " + villano.getSalud());
                // Marcar que el villano ya no puede curarse más
                puedeCurarse = false;
            }
        } else {
            System.out.println("Opcion no valida.");
        }

    }
}

