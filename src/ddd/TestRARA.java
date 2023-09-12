/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddd;

/**
 *
 * @author netor
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author usuario
 */
public class TestRARA {
    public static void main(String[] args) {
        long inicio, fin;
        int[] arreglo=new int[40];
        ForkJoinPool fjp=new ForkJoinPool();
        
        RandomArregloRA rara=new RandomArregloRA(arreglo, 0, arreglo.length);
        
        inicio=System.currentTimeMillis();
        fjp.invoke(rara);
        fin=System.currentTimeMillis();
        
        System.out.println("Tiempo "+(fin-inicio));
    }
}