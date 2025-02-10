package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Personaje[] superheroes = crearArraySuperheroes();
        Personaje[] villanos = crearArrayVillanos();
        imprimirArray(superheroes);
        imprimirArray(villanos);
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

    private static void imprimirMenu(){
        System.out.println("Bienvenidos al juego de Super Mario Bros!");
        System.out.println("1) Mostrar personajes");
        System.out.println("2) Escoge tu superheroe");
        System.out.println("3) Escoge tu villano");
        System.out.println("4) Escoge tu villano de manera aleatoria");
    }

    private static int opcionMenu(){
        System.out.println("Escoge una opcion: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
    }

    private static void imprimirArray(Personaje[] personajes) {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }


}