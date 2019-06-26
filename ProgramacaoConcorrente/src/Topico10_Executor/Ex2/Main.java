/*
 * 2. Fa¸ca um programa que calcule a soma dos elementos de uma matriz
MxN. Divida o programa em tarefas que somam as linhas. O programa
deve possibilitar especificar o n´umero de threads para resolver o problema.
 */
package Topico10_Executor.Ex2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class Main {
    
    public static void main(String[] args) {
        
        int qtdThreads = 2;
        int matriz[][] = {{1,2},{3,4}};
        int soma = 0;
        
        ExecutorService executorService = Executors.newFixedThreadPool(qtdThreads);
        
        
        for (int i = 0; i < matriz.length; i++) {
            SomaLinhasMatrizTask maiorValorTask = new SomaLinhasMatrizTask(matriz[i]);
            Future<Integer> future = executorService.submit(maiorValorTask);

            
            try {
                soma = soma + future.get();
            } catch (InterruptedException | ExecutionException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        
        executorService.shutdown();
        while(! executorService.isTerminated()){
            //do nothing
        }
        System.out.println("Soma: "+ soma);
        System.out.println("Finished all threads");
    }
    
}
