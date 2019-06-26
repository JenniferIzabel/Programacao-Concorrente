/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico11_Colecoes.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author jennifer
 */
public class Consumidor implements Callable<Integer>{
    BlockingQueue blockingQueue;
    int qtdConsumidores = 2;
    ExecutorService executorServiceConsumidor;
    
    public Consumidor(BlockingQueue queue) {
        this.blockingQueue  = queue;
        

    }

    @Override
    public Integer call() throws Exception {
        executorServiceConsumidor = Executors.newFixedThreadPool(qtdConsumidores);
        Consumidor consumidor = new Consumidor(blockingQueue);
       // Future<Integer> futureConsumidor = executorServiceConsumidor.submit(consumidor);
       
       while(true){
        int n =  (Integer) blockingQueue.take();
        System.out.println("Consumiu: "+n);
        Thread.sleep(1000);   
       }
        //return n;
    }

}
