/*
 *1. Fa¸ca um programa que localize o maior valor em um vetor. Divida o
programa em tarefas que localizam o maior valor em um segmento do
vetor. O programa deve possibilitar especificar o n´umero de tarefas e o
n´umero de threads para resolver o problema.
 */
package Topico10_Executor.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.jvm.hotspot.utilities.WorkerThread;

/**
 *
 * @author jennifer
 */
public class Main {
    
    public static void main(String[] args) {
        
        int qtdTasks = 5;
        int qtdThreads = 2;
        int lista[] = {45,45,65,50,1151,211,216,216,21,6,8};
        int outra[] = new int[qtdTasks];
        
        ExecutorService executorService = Executors.newFixedThreadPool(qtdThreads);
        
        int tamSublista = lista.length / qtdTasks;
        System.out.println("Tamanho da subLista:"+ tamSublista);
        int a = 0;
        int b = tamSublista;
        
        for (int i = 0; i < qtdTasks; i++) {
            MaiorValorTask maiorValorTask = new MaiorValorTask(lista, a, b);
            Future<Integer> future = executorService.submit(maiorValorTask);
            a = a + tamSublista;
            b = b + tamSublista;
            
            try {
                outra[i] = future.get();
            } catch (InterruptedException | ExecutionException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        MaiorValorTask maiorValorTask = new MaiorValorTask(outra, 0, qtdTasks);
        Future<Integer> future = executorService.submit(maiorValorTask);
        try {
                System.out.println("Maior: "+ future.get());
            } catch (InterruptedException | ExecutionException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        
        executorService.shutdown();
        while(! executorService.isTerminated()){
            //do nothing
        }
        System.out.println("Finished all threads");
    }
    
}
