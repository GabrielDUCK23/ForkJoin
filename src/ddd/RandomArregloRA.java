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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author usuario
 */
public class RandomArregloRA extends RecursiveAction{
    private int[] arreglo;
    private static final int umbral=10;
    private int inicio, fin;
    
    public RandomArregloRA(int[] arreglo, int inicio, int fin){
        this.arreglo=arreglo;
        this.inicio=inicio;
        this.fin=fin;
    }

    @Override
    protected void compute() {
        if((fin-inicio) > umbral){
            ForkJoinTask.invokeAll(divisionTareas());
        }else{
            proceso(arreglo, inicio, fin);
        }
    }
    
    public void proceso(int[] arreglo,int inicio, int fin){
        System.out.println("Trabajo desde "+inicio+" hasta "+fin);
        String llenado="";
        for (int i = inicio; i < fin; i++) {
            arreglo[i]=(int)(Math.random()*100);
            llenado+="a["+i+"]="+arreglo[i]+",";
        }
        System.out.println(llenado);
    }
    
    public List<RandomArregloRA> divisionTareas(){
        List<RandomArregloRA> subtasks = new ArrayList<>();

//        String partOne = workload.substring(0, workload.length() / 2);
//        String partTwo = workload.substring(workload.length() / 2, workload.length());

        subtasks.add(new RandomArregloRA(arreglo, inicio, (inicio+fin)/2));
        subtasks.add(new RandomArregloRA(arreglo, (inicio+fin)/2, fin));

        return subtasks;
    }
    
}