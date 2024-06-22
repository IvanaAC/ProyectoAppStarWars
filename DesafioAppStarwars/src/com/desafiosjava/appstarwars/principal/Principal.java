package com.desafiosjava.appstarwars.principal;

import com.desafiosjava.appstarwars.modelos.ConsultaPelicula;
import com.desafiosjava.appstarwars.modelos.GeneradorDeArchivo;
import com.desafiosjava.appstarwars.modelos.Pelicula;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        boolean salir = false;

        String menu= """
                \n*************************************************************
                Directorio de Star Wars 
                \nBienvenido! :D
                \nEste es el listado de películas: 
                1-A New Hope
                2-The Empire Strikes Back
                3-Return of the Jedi
                4-The Phantom Menace
                5-Attack of the Clones
                6-Revenge of the Sith
                7-The Force Awakens
                8-Salir
                *************************************************************
                ¿Cúal es la película de Star Wars que quieres consultar?: 
                """;

        while (!salir) {
            System.out.println(menu);
            String input = lectura.nextLine();
            try {
                int numeroDePelicula = Integer.parseInt(input);
                if (numeroDePelicula ==8){
                    salir = true;
                    System.out.println("Gracias por usar la aplicación.");
                }else {
                    Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
                    System.out.println(pelicula);
                    System.out.println("\nTu consulta fue guardada.");
                    GeneradorDeArchivo generador = new GeneradorDeArchivo();
                    generador.guardarJson(pelicula);
                }
            } catch (NumberFormatException e) {
                System.out.println("El dato ingresado no es una opción válida. " + e.getMessage());
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
        lectura.close();
    }
}
