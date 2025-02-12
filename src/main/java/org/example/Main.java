package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        Personaje[] superheroes = crearArraySuperheroes();
        Personaje[] villanos = crearArrayVillanos();
        imprimirMenu();
        int option = 0;
        while ((option = opcionMenu()) != 10){
            switch (option) {
                case 1 :
                    imprimirArray(superheroes);
                    imprimirArray(villanos);
                    break;
                case 2 :
                    imprimirArray(superheroes);
                    System.out.println("Que superheroe escogeras?");
                    int numSuperheroe = scanner.nextInt();
                    if (comprobarOpcion(numSuperheroe)){
                        System.out.println("Tu superheroe sera " + escogerPersonaje(superheroes, numSuperheroe).getNombre());
                    }
                    break;
                case 3 :
                    imprimirArray(villanos);
                    System.out.println("Que villano escogeras?");
                    int numVillano = scanner.nextInt();
                    if (comprobarOpcion(numVillano)){
                        System.out.println("Tu villano sera " + escogerPersonaje(villanos, numVillano).getNombre());
                    }
                    break;
                case 4 :
                    System.out.println("Tu personaje sera: " + superheroes[random.nextInt(0,4)].getNombre());
                    break;

                case 5 :
                    System.out.println("Tu personaje sera: " + villanos[random.nextInt(0,4)].getNombre());
                    break;

                case 6 :
                    System.out.println("Has salido del juego!");
                    break;
            }
        }

    }
    private static void imprimirMenu(){
        System.out.println("Bienvenidos al juego de Super Mario Bros!");
        System.out.println("1) Mostrar personajes");
        System.out.println("2) Escoge tu superheroe");
        System.out.println("3) Escoge tu villano");
        System.out.println("4) Escoge tu superheroe de manera aleatoria");
        System.out.println("5) Escoge tu villano de manera aleatoria");
        System.out.println("6) Salir");
    }

    private static int opcionMenu(){
        System.out.println("Escoge una opcion: ");
        int opcion = scanner.nextInt();
        return opcion;
    }

    private static Personaje[] crearArraySuperheroes(){
        //Creacion de los superheroes
        Superheroe mario = new Superheroe("Mario", 10, 10);
        Superheroe luigi = new Superheroe("Luigi", 10, 9);
        //Creacion de objeto con el polimorfismo
        Personaje peach = new Superheroe("Princesa Peach", 8, 5);
        Personaje yoshi = new Superheroe("Yoshi", 8, 10);
        Personaje toad = new Superheroe("Toad", 7, 7);
        //Creacion de array de superheroes
        Personaje[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private static Personaje[] crearArrayVillanos() {
        //Creacion de villanos
        Villano browser = new Villano("Browser", 10, 9);
        Villano wario = new Villano("Wario", 9, 9);
        //Creacion de objeto con el polimorfismo
        Personaje waluigi = new Villano("Waluigi", 8, 8);
        Personaje donkeykong = new Villano("Donkey Kong", 10, 10);
        Personaje reyboo = new Villano("Rey Boo", 9, 8);

        //Creacion de array de villanos
        Personaje[] villanos = {browser, waluigi, wario, donkeykong, reyboo};
        return villanos;
    }

    private static void imprimirArray(Personaje[] personajes) {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    private static Personaje escogerPersonaje(Personaje[] personajes, int opcion){
        return personajes[opcion - 1];
    }

    private static boolean comprobarOpcion(int opcion){
        if (opcion < 5 && opcion > 0){
            return true;
        }
        return false;
    }
}