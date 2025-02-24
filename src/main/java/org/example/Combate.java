package org.example;

import java.util.Scanner;
import java.util.Random;

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
        Superheroe mario = new Superheroe("Mario", 8, 7);
        Superheroe luigi = new Superheroe("Luigi", 7, 6);
        //Creación de objeto con el polimorfismo
        Superheroe peach = new Superheroe("Princesa Peach", 4, 3);
        Superheroe yoshi = new Superheroe("Yoshi", 6, 5);
        Superheroe toad = new Superheroe("Toad", 5, 4);
        //Creacion de array de superheroes
        Superheroe[] superheroes = {mario, luigi, peach, yoshi, toad};
        return superheroes;
    }

    private Villano[] crearArrayVillanos() {
        //Creacion de villanos
        Villano browser = new Villano("Browser", 10, 9);
        Villano wario = new Villano("Wario", 7, 7);
        //Creacion de objeto con el polimorfismo
        Villano waluigi = new Villano("Waluigi", 7, 6);
        Villano donkeykong = new Villano("Donkey Kong", 8, 8);
        Villano reyboo = new Villano("Rey Boo", 7, 5);

        //Creacion de array de villanos
        Villano[] villanos = {browser, waluigi, wario, donkeykong, reyboo};
        return villanos;
    }

    private Objeto[] crearArrayObjeto() {
        //Creacion de objetos
        Objeto champiñonRojo = new Objeto("Champiñon Rojo", "Te hace mas grande. ", 6);
        Objeto florDeFuego = new Objeto("Flor de fuego", "Lanzar bolas de fuego. ", 8);
        Objeto florDeHielo = new Objeto("Flor de hielo", "Lanzar bolas de hielo. ", 8);
        //Creacion de objetos con el polimorfismo
        Objeto estrella = new Objeto("Estrella", "Te vuelve invencible. ", 10);

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("¡LA BATALLA HA EMPEZADO!");
        System.out.println("-------------------------------");
        System.out.println("Tu superheroe sera " + superheroeEscogido.getNombre());
        System.out.println("El objeto escogido para tu superheroe sera: " + objeto.getNombre() + " Poder: " + objeto.getPoder() + " Daño: " + objeto.getDaño());
        System.out.println("Tu villano sera " + villanoEscogido.getNombre());
        while (superheroeEscogido.getSalud() > 0 && villanoEscogido.getSalud() > 0) {
            // Turno del superhéroe
            System.out.println("Es turno de " + superheroeEscogido.getNombre());
            System.out.println("Presiona:");
            System.out.println("1) Atacar 2) Saltar y aplastar 3) Esquivar ataque 4) Curarte con Champiñon Verde");

            int turnoAtaqueSuperheroe = scanner.nextInt();
            if(turnoAtaqueSuperheroe == 1 || turnoAtaqueSuperheroe == 2 || turnoAtaqueSuperheroe == 3 || turnoAtaqueSuperheroe == 4) {
                Random random = new Random(); // Para generar probabilidades aleatorias
                int saludOriginalSuperheroe = superheroeEscogido.getSalud();
                int saludOriginalVillano = villanoEscogido.getSalud();
                int dañoInfringidoSuperheroe = (superheroeEscogido.getAtaque() + objeto.getDaño()) - villanoEscogido.getDefensa();
                if (turnoAtaqueSuperheroe == 1){
                    villanoEscogido.setSalud(Math.max(0, villanoEscogido.getSalud() - dañoInfringidoSuperheroe));
                    System.out.println(superheroeEscogido.getNombre() + " ha atacado a " + villanoEscogido.getNombre());
                    System.out.println("Salud: " + villanoEscogido.getSalud());
                } else if (turnoAtaqueSuperheroe == 2) {
                    villanoEscogido.setSalud(Math.max(0, villanoEscogido.getSalud() - dañoInfringidoSuperheroe));
                    System.out.println(superheroeEscogido.getNombre() + " ha aplastado a " + villanoEscogido.getNombre());
                    System.out.println("Salud: " + villanoEscogido.getSalud());
                } else if (turnoAtaqueSuperheroe == 3) {
                    if (random.nextBoolean()) {
                        System.out.println(superheroeEscogido.getNombre() + " ha esquivado el siguiente ataque.");
                        System.out.println("Salud: " + superheroeEscogido.getSalud());
                        continue;
                    } else {
                        System.out.println(superheroeEscogido.getNombre() + " intentó esquivar, pero falló.");
                        System.out.println("Salud: " + superheroeEscogido.getSalud());
                    }
                }
                else if (turnoAtaqueSuperheroe == 4) {
                    System.out.println(superheroeEscogido.getNombre() + " ha recuperado su salud completamente.");
                    System.out.println("Salud: " + saludOriginalSuperheroe);

                    } else {
                        System.out.println("Valor introducido incorrecto.");
                        continue;
                    }

                    // Si el villano murió, terminamos el bucle
                if (villanoEscogido.getSalud() <= 0) {
                    System.out.println("-------------------------------");
                    System.out.println("¡LA BATALLA HA TERMINADO!");
                    System.out.println("-------------------------------");
                    System.out.println(villanoEscogido.getNombre() + " HA SIDO DERROTADO.");
                    System.out.println(superheroeEscogido.getNombre() + " ES EL GANADOR.");
                    break;
                } else {
                    // Turno del villano
                    System.out.println("Es turno de " + villanoEscogido.getNombre());
                    System.out.println("Presiona: ");
                    System.out.println("1) Atacar 2) Superataque 3) Esquivar ataque 4) Curarte con pocion magica");


                    int turnoAtaqueVillano = scanner.nextInt();
                    int dañoInfringidoVillano = villanoEscogido.getAtaque() - superheroeEscogido.getDefensa();

                    if (turnoAtaqueVillano == 1) {
                        superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano));
                        System.out.println(villanoEscogido.getNombre() + " ha atacado a " + superheroeEscogido.getNombre());
                        System.out.println("Salud: " + superheroeEscogido.getSalud());
                    } else if (turnoAtaqueVillano == 2){
                        superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano * 2));
                        System.out.println(villanoEscogido.getNombre() + " ha hecho superataque a " + superheroeEscogido.getNombre());
                        System.out.println("Salud: " + superheroeEscogido.getSalud());
                    } else if (turnoAtaqueVillano == 3) {
                        if (random.nextBoolean()) {
                            superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano * 2));
                            System.out.println(villanoEscogido.getNombre() + " ha esquivado el siguiente ataque.");
                            System.out.println("Salud: " + villanoEscogido.getSalud());
                            continue;
                        } else {
                            superheroeEscogido.setSalud(Math.max(0, superheroeEscogido.getSalud() - dañoInfringidoVillano * 2));
                            System.out.println(villanoEscogido.getNombre() + " intentó esquivar, pero falló.");
                            System.out.println("Salud: " + villanoEscogido.getSalud());
                        } }
                        else if (turnoAtaqueVillano == 4) {
                            System.out.println(villanoEscogido.getNombre() + " ha recuperado su salud completamente.");
                            System.out.println("Salud: " + saludOriginalVillano);

                    }  else {
                        System.out.println("Valor introducido incorrecto.");
                        continue;
                    }

                    // Si el superhéroe murió, terminamos el bucle
                    if (superheroeEscogido.getSalud() <= 0) {
                        System.out.println("-------------------------------");
                        System.out.println("¡LA BATALLA HA TERMINADO!");
                        System.out.println("-------------------------------");
                        System.out.println(superheroeEscogido.getNombre() + " HA SIDO DERROTADO.");
                        System.out.println(villanoEscogido.getNombre() + " ES EL GANADOR.");
                        break;
                    }
                }
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

