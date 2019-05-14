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
public class ThreadClassA extends Thread {

    private final Semaphore semaphoreX;
    private final Semaphore semaphoreY;

    public ThreadClassA(Semaphore semaphoreX, Semaphore semaphoreY) {
        this.semaphoreX = semaphoreX;   
        this.semaphoreY = semaphoreY;   
    }
    
    private void a1() throws InterruptedException{
        System.out.println("Executando parte A1");
        Thread.sleep(2000); // esperar um tempo
    }
    
    private void a2(){
        System.out.println("Executando parte A2");
    }

    @Override
    public void run() {
        try {            
            System.out.println("Thread A");
            
            a1(); // executa a primeira parte
            
            
            System.out.println("parte A2 esperando a parte B1");
            semaphoreX.acquire();
            a2();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Sinaliza com um release");
            semaphoreX.release();
        }
    }

}
