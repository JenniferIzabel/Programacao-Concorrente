/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico10_Tarefas.Fatorial;

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
public class FatorialMain {

    public static void main(String[] args) {
        boolean x = false;
        int n = 5;

        if (x) {
            //runnable
            FatorialRunnableTask frt = new FatorialRunnableTask(n);
            Thread t = new Thread(frt);
            t.start();
            
            try {
                t.join();
                System.out.println("Runnable result of " + n + "!: " + frt.getResultado());
            } catch (InterruptedException ex) {
                Logger.getLogger(FatorialMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else { 
            //callable
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            FatorialCallableTask fct = new FatorialCallableTask(n);
            Future<Integer> future = executorService.submit(fct);

            try {
                System.out.println("Callable result of " + n + "!: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                Logger.getLogger(FatorialMain.class.getName()).log(Level.SEVERE, null, e);

            }
            
            executorService.shutdown();

        }

    }
}
