/*
2. Rendezvous (Encontro)
Enviar sinalização para um ponto de encontro entre threads.
Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.

Exemplo:
t1:
trecho.a1
trecho.a2

t2:
trecho.b1
trecho.b2

thecho.a1 ocorre antes trecho.b2 e threcho.b1 ocorre antes de trecho.a2.

semaphoreX : a1 -> b2
semaphoreY: b1 -> a2 
 */
package Topico7_Semaforo.Rendezvous;

import java.util.concurrent.Semaphore;

/**
 *
 * @author jennifer
 */
public class Rendezvous {
    private final Semaphore semaphoreX = new Semaphore(0); // a1 -> b2
    private final Semaphore semaphoreY = new Semaphore(0); // b1 -> a2    

    public Rendezvous() {
        ThreadClassA t1 = new ThreadClassA(semaphoreX, semaphoreY);
        ThreadClassB t2 = new ThreadClassB(semaphoreX, semaphoreY);

        t1.start();
        t2.start();
    }
    
    public static void main(String[] args) {
        new Rendezvous();
    }

}
