/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fork.join;

/**
 *
 * @author netor /* Click
 * nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to
 * change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author usuario
 */
// Gabriel Ernesto Rios Sánchez
// Jair Alfonso Suarez Flores 
// Hector Ulises Sánchez Gonzalez 
import java.util.concurrent.ForkJoinPool;

public class TestRARA {

    public static void main(String[] args) {
        System.out.println("Gabriel Ernesto Rios Sanchez\nJair Alfonso Suarez Flores\nHector Ulises Sánchez Gonzalez ");
//        long inicio, fin, fin2,inicio2;
        int[][] matriz = new int[100][100]; // Cambiar las dimensiones según tus necesidades
        int[][] matriz2 = new int[100][100]; // Cambiar las dimensiones según tus necesidades

        ForkJoinPool fjp = new ForkJoinPool();

        RandomArregloRA rara = new RandomArregloRA(matriz, 0, matriz.length, 0, matriz[0].length);

        long inicio = System.nanoTime();
        fjp.invoke(rara);
        long fin = System.nanoTime();

        System.out.println("\n" + "Tiempo " + (fin - inicio));

       long  inicio2 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                matriz2[i][j] = (int) (Math.random() * 100);

            }
        }
        
        long fin2 = System.nanoTime();
        System.out.println("\n" + "Tiempo Secuencial " + (fin2 - inicio2));

//        imprimirMatriz(matriz);
        System.out.println("\nGabriel Ernesto Rios Sanchez\nJair Alfonso Suarez Flores\nHector Ulises Sánchez Gonzalez ");

    }

//    public static void imprimirMatriz(int[][] matriz) {
//        System.out.println("");
//        System.out.println("Matriz resultante:");
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j] + " ");
//            }
//            System.out.println();
//            
//        }
//        System.out.println("\nGabriel Ernesto Rios Sanchez\nJair Alfonso Suarez Flores\nHector Ulises Sánchez Gonzalez ");
}
