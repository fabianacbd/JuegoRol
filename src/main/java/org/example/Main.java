package org.example;

import java.io.ObjectStreamException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static Combate combate = new Combate();
    public static void main(String[] args) {
        //Declaración de variables
        int option = 0;
        Superheroe[] superheroes = combate.getSuperheroes();
        Villano[] villanos = combate.getVillanos();
        Objeto[] objetos = combate.getObjetos();

        //Código
        imprimirMenu();
        while ((option = opcionMenu()) != 4) {
            switch (option) {
                case 1 -> {
                    System.out.println("SUPERHEROES:");
                    combate.imprimirArray(superheroes);
                    System.out.println("VILLANOS:");
                    combate.imprimirArray(villanos);
                }
                case 2 -> {
                    System.out.println("¿Que superheroe escogeras?");
                    combate.imprimirArray(superheroes);
                    int numSuperheroe = scanner.nextInt();
                    if (combate.comprobarOpcionPersonajes(superheroes, numSuperheroe)) {
                        Superheroe superheroeEscogido = combate.escogerSuperheroe(superheroes, numSuperheroe);
                        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
                        System.out.println("¿Que villano escogeras?");
                        combate.imprimirArray(villanos);
                        int numVillano = scanner.nextInt();
                        Villano villanoEscogido = combate.escogerVillanos(villanos, numVillano);
                        if (combate.comprobarOpcionPersonajes(villanos, numVillano)) {
                            System.out.println("Tu villano sera " + villanoEscogido.getNombre());
                            System.out.println("¿Que objeto escogeras para tu superheroe?");
                            combate.imprimirArrayObjetos(objetos);
                            int numObjeto = scanner.nextInt();
                            if (combate.comprobarOpcionObjetos(objetos, numObjeto)) {
                                Objeto objetoEscogido = combate.escogerObjeto(objetos, numObjeto);
                                combate.luchaPersonajes(superheroeEscogido, villanoEscogido, objetoEscogido);
                            }
                            imprimirMenu();
                        }

                    }
                }
                case 3 -> {
                    Superheroe superheroeEscogido = superheroes[random.nextInt(0, 4)];
                    System.out.println("Tu superheroe sera: ");
                    System.out.println(superheroeEscogido);
                    Villano villanoEscogido = villanos[random.nextInt(0, 4)];
                    System.out.println("Tu villano sera: ");
                    System.out.println(villanoEscogido);
                    Objeto objetoEscogido = objetos[random.nextInt(0,4)];
                    System.out.println("Tu objeto sera: ");
                    System.out.println(objetoEscogido);
                    combate.luchaPersonajes(superheroeEscogido, villanoEscogido, objetoEscogido);
                }
                case 4 -> System.out.println("Has salido del juego!");
                default -> System.out.println("Opcion invalida.");
            }
        }

    }
    private static void imprimirMenu(){
        System.out.println("+---------------------------------------------+");
        System.out.println("| Bienvenidos al juego de Super Mario Bros!   |");
        System.out.println("| 1) Mostrar todos los personajes             |");
        System.out.println("| 2) Escoge tus personajes manualmente        |");
        System.out.println("| 3) Escoger personajes aleatoriamente        |");
        System.out.println("| 4) Salir                                    |");
        System.out.println("+---------------------------------------------+");
    }

    private static int opcionMenu(){
        System.out.println("Escoge una opcion: ");
        int opcion = scanner.nextInt();
        return opcion;
    }

}