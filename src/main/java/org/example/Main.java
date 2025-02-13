package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        Superheroe[] superheroes = crearArraySuperheroes();
        Villano[] villanos = crearArrayVillanos();
        Objeto[] objetos = crearArrayObjeto();
        imprimirMenu();
        int option = 0;
        while ((option = opcionMenu()) != 10){
            switch (option) {
                case 1 :
                    imprimirArray(superheroes);
                    imprimirArray(villanos);
                    break;
                case 2 :
                    System.out.println("Que superheroe escogeras?");
                    imprimirArray(superheroes);
                    int numSuperheroe = scanner.nextInt();
                    if (comprobarOpcion(numSuperheroe)){
                        Superheroe superheroeEscogido = escogerSuperheroe(superheroes, numSuperheroe);
                        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
                        System.out.println("Que villano escogeras?");
                        imprimirArray(villanos);
                        int numVillano = scanner.nextInt();
                        Villano villanoEscogido = escogerVillanos(villanos, numVillano);
                        if (comprobarOpcion(numVillano)){
                            System.out.println("Tu villano sera " + villanoEscogido.getNombre());
                            System.out.println("Que objeto escogeras para tu superheroe?");
                            imprimirArrayObjeto(objetos);
                            int numObjeto = scanner.nextInt();
                            if (comprobarOpcion(numObjeto)){
                                Objeto objetoSuperheroe = escogerObjeto(objetos, numObjeto);
                                System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
                                System.out.println("El objeto escogido para tu superheroe sera: " + objetoSuperheroe.getNombre() + ". Poder: " + objetoSuperheroe.getPoder() + ". Daño: " + objetoSuperheroe.getDaño());
                                luchaPersonajes(superheroeEscogido, villanoEscogido, objetoSuperheroe);
                            }
                        }

                    }
                    break;
                case 3 :
                    Personaje superheroeEscogido = superheroes[random.nextInt(0,4)];
                    System.out.println("Tu personaje sera: " + superheroes[random.nextInt(0,4)].getNombre());
                    Personaje villanoEscogido = villanos[random.nextInt(0,4)];
                    System.out.println("Tu personaje sera: " + villanos[random.nextInt(0,4)].getNombre());

                    break;
                case 4 :
                    System.out.println("Has salido del juego!");
                    break;
            }
        }

    }
    private static void imprimirMenu(){
        System.out.println("Bienvenidos al juego de Super Mario Bros!");
        System.out.println("1) Mostrar personajes");
        System.out.println("2) Escoge tus personajes");
        System.out.println("3) Escoge tus personajes de manera aleatoria");
        System.out.println("4) Salir");
    }

    private static int opcionMenu(){
        System.out.println("Escoge una opcion: ");
        int opcion = scanner.nextInt();
        return opcion;
    }

    private static Superheroe[] crearArraySuperheroes(){
        //Creacion de los superheroes
        Superheroe mario = new Superheroe("Mario", 10, 10);
        Superheroe luigi = new Superheroe("Luigi", 10, 9);
        //Creacion de objeto con el polimorfismo
        Superheroe peach = new Superheroe("Princesa Peach", 8, 5);
        Superheroe yoshi = new Superheroe("Yoshi", 8, 10);
        Superheroe toad = new Superheroe("Toad", 7, 7);
        //Creacion de array de superheroes
        Superheroe[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private static Villano[] crearArrayVillanos() {
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

    private static Objeto[] crearArrayObjeto() {
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

    private static void imprimirArray(Personaje[] personajes) {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    private static void imprimirArrayObjeto(Objeto[] objetos) {
        for (Objeto o : objetos) {
            System.out.println(o);
        }
    }

    private static Superheroe escogerSuperheroe(Superheroe[] superheroes, int opcion){
        return superheroes[opcion - 1];
    }

    private static Villano escogerVillanos(Villano[] villanos, int opcion){
        return villanos[opcion - 1];
    }

    private static Objeto escogerObjeto(Objeto[] objetos, int opcion){
        return objetos[opcion - 1];
    }

    private static boolean comprobarOpcion(int opcion){
        if (opcion < 5 && opcion > 0){
            return true;
        }
        return false;
    }

    private static void luchaPersonajes(Superheroe superheroeEscogido, Villano villanoEscogido, Objeto objeto) {
        System.out.println("La lucha ha comenzado!");
        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
        System.out.println("El objeto escogido para tu superheroe sera: " + objeto.getNombre() + ". Poder: " + objeto.getPoder() + ". Daño: " + objeto.getDaño());
        System.out.println("Tu villano sera " + villanoEscogido.getNombre());
    }
}