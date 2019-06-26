/*
Implemente duas vers˜oes do problema do produtor/consumidor com M
produtores e N consumidores usando ArrayBlockingQueue e
LinkedBlockingQueue. Compare o desempenho das duas
implementa¸c˜oes.
 */
package Topico11_Colecoes.BlockingQueue;

import Topico10_Executor.Ex2.SomaLinhasMatrizTask;
import java.awt.SystemColor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class MainBlockingQueue {

    public static void main(String[] args) {


        int qtdProdutores = 2;
        int qtdConsumidores = 2;
        int tamBuffer = 10;

        BlockingQueue blockingQueue;

        ExecutorService executorServiceProdutor = Executors.newFixedThreadPool(qtdProdutores);
        ExecutorService executorServiceConsumidor = Executors.newFixedThreadPool(qtdConsumidores);

        boolean tipo = true; //TRUE  = ArrayBlockingQueue; FALSE = LinkedBlockingQueue
        
        if (tipo) {
            blockingQueue = new ArrayBlockingQueue(tamBuffer);
        } else { 
            blockingQueue = new LinkedBlockingQueue(tamBuffer);
        }

        Produtor produtor = new Produtor(blockingQueue);
        Consumidor consumidor = new Consumidor(blockingQueue);
        
        Future<Integer> futureProdutor = executorServiceProdutor.submit(produtor);
        Future<Integer> futureConsumidor = executorServiceConsumidor.submit(consumidor);
    }

}
