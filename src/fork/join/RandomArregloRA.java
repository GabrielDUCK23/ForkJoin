/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fork.join;

/**
 *
 * @author netor
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class RandomArregloRA extends RecursiveAction {
    private int[][] matriz;
    private static final int umbral = 10;
    private int filaInicio, filaFin, columnaInicio, columnaFin;

    public RandomArregloRA(int[][] matriz, int filaInicio, int filaFin, int columnaInicio, int columnaFin) {
        this.matriz = matriz;
        this.filaInicio = filaInicio;
        this.filaFin = filaFin;
        this.columnaInicio = columnaInicio;
        this.columnaFin = columnaFin;
    }

    @Override
    protected void compute() {
        if ((filaFin - filaInicio) > umbral || (columnaFin - columnaInicio) > umbral) {
            ForkJoinTask.invokeAll(divisionTareas());
        } else {
            proceso(matriz, filaInicio, filaFin, columnaInicio, columnaFin);
        }
    }

   public void proceso(int[][] matriz, int filaInicio, int filaFin, int columnaInicio, int columnaFin) {
//    System.out.println("Trabajo desde (" + filaInicio + ", " + columnaInicio + ") hasta (" + filaFin + ", " + columnaFin + ")");
//    String llenado = "";
    for (int i = filaInicio; i < filaFin; i++) {
        for (int j = columnaInicio; j < columnaFin; j++) {
            matriz[i][j] = (int) (Math.random() * 100);
//            llenado += "matriz[" + i + "][" + j + "]=" + matriz[i][j] + ",";
        }
    }
//    System.out.println(llenado + "\n"); // Agrega "\n" al final para un salto de línea
}
   
   


     
     
    public List<RandomArregloRA> divisionTareas() {
        
        List<RandomArregloRA> subtasks = new ArrayList<>();
        int filaMedia = (filaInicio + filaFin) / 2;
        int columnaMedia = (columnaInicio + columnaFin) / 2;

        subtasks.add(new RandomArregloRA(matriz, filaInicio, filaMedia, columnaInicio, columnaMedia));
        subtasks.add(new RandomArregloRA(matriz, filaInicio, filaMedia, columnaMedia, columnaFin));
        subtasks.add(new RandomArregloRA(matriz, filaMedia, filaFin, columnaInicio, columnaMedia));
        subtasks.add(new RandomArregloRA(matriz, filaMedia, filaFin, columnaMedia, columnaFin));

        return subtasks;
    }
}