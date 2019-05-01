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
public class ThreadClassB extends Thread {

    private final Semaphore semaphore;

    public ThreadClassB(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread B esperando a Thread A");
            semaphore.acquire();
            
            System.out.println("Thread B recebeu a vez");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Fim");
        }
    }

}
