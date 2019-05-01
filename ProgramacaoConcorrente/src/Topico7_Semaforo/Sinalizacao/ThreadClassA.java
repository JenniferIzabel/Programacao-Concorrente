/*
 *1. Sinalização
Enviar sinal para outra thread para indicar que um evento ocorreu.

Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, mas a t2 pode somente
continuar a execução após a sinalização de t1.
 */
package Topico7_Semaforo.Sinalizacao;

import java.util.concurrent.Semaphore;

/**
 *
 * @author jennifer
 */
public class ThreadClassA extends Thread {

    private final Semaphore semaphore;

    public ThreadClassA(Semaphore semaphore) {
        this.semaphore = semaphore;
        
    }

    @Override
    public void run() {
        try {            
            System.out.println("Executando a Thread A");

            Thread.sleep(4000); // esperar um tempo

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Sinaliza com um release");
            semaphore.release();
        }
    }

}
