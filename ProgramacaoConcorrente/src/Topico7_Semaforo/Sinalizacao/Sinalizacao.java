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
public class Sinalizacao {    
    private final Semaphore semaphore = new Semaphore(0);

    public Sinalizacao() {
        ThreadClassA threadClassA = new ThreadClassA(semaphore);
        ThreadClassB threadClassB = new ThreadClassB(semaphore);

        threadClassA.start();
        threadClassB.start();
        
    }
    
    public static void main(String[] args) {
        new Sinalizacao();
    }
    
    
}
