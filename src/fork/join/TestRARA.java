/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fork.join;

/**
 *
 * @author netor
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author usuario
 */
import java.util.concurrent.ForkJoinPool;


public class TestRARA {
    public static void main(String[] args) {
        long inicio, fin;
        int[][] matriz = new int[100][100]; // Cambiar las dimensiones según tus necesidades
        ForkJoinPool fjp = new ForkJoinPool();

        RandomArregloRA rara = new RandomArregloRA(matriz, 0, matriz.length, 0, matriz[0].length);

        inicio = System.currentTimeMillis();
        fjp.invoke(rara);
        fin = System.currentTimeMillis();

        System.out.println("\n"+"Tiempo " + (fin - inicio));
        
        imprimirMatriz(matriz);
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("");
        System.out.println("Matriz resultante:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
            
        }
       
    }
}
