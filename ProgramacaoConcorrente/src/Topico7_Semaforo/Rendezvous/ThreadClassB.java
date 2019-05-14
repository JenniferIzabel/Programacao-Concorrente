/*
 *
semaphoreX : a1 -> b2
semaphoreY: b1 -> a2 
 */
package Topico7_Semaforo.Rendezvous;

import java.util.concurrent.Semaphore;

/**
 *
 * @author jennifer
 */
public class ThreadClassB extends Thread {

    private final Semaphore semaphoreX;
    private final Semaphore semaphoreY;

    public ThreadClassB(Semaphore semaphoreX, Semaphore semaphoreY) {
        this.semaphoreX = semaphoreX;   
        this.semaphoreY = semaphoreY;   
    }
    
    private void b1() throws InterruptedException{
        System.out.println("Executando parte B1");
        Thread.sleep(2000); // esperar um tempo
    }
    
    private void b2(){
        System.out.println("Executando parte B2");
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread B");
            
            b1(); // executa a primeira parte
            
            System.out.println("parte B2 esperando a parte A1");
            semaphoreX.acquire();
            b2();
            
            

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } 
    }

}
