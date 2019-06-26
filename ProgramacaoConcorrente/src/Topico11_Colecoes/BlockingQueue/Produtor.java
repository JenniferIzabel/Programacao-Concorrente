/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico11_Colecoes.BlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author jennifer
 */
public class Produtor implements Callable<Integer>{
    BlockingQueue blockingQueue;
    int qtdProdutores = 2;
    ExecutorService executorServiceProdutor;
    
    public Produtor(BlockingQueue queue) {
        this.blockingQueue  = queue;
        
        
    }
    
    private int geraNum(){
        Random r = new Random();
        return r.nextInt();
    }

    @Override
    public Integer call() throws Exception {
        executorServiceProdutor = Executors.newFixedThreadPool(qtdProdutores);
        Produtor produtor = new Produtor(blockingQueue);
        // Future<Integer> futureProdutor = executorServiceProdutor.submit(produtor);
        
        while(true){
            int n = geraNum();
            blockingQueue.put(n);
            System.out.println("Produziu: "+n);
            Thread.sleep(100);
        }
        
        //return n;
    }

   
    
}
