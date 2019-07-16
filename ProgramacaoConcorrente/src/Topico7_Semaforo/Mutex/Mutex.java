/*
 * 3. Mutex (Exclusão Mútua)
Garantir acesso exclusivo à seção crítica.
Faça um código que possibilite que 2 ou mais threads realizem o incremento de um contador. Faça a
exclusão mútua com semáforo.
 */
package Topico7_Semaforo.Mutex;

import Topico3_Thread.slide_28.a1_ConsultarEstados;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class Mutex extends Thread {

    BinarySemaphore mutex;
    int cont = 0;

    Mutex(BinarySemaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mutex.P();
                System.out.println("cont: " + ++cont);
                Thread.sleep(1000);
                mutex.V();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mutex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        BinarySemaphore mutex = new BinarySemaphore(true);

        Thread t1 = new Thread(new Mutex(mutex));
        t1.start();
        Thread t2 = new Thread(new Mutex(mutex));
        t2.start();
        Thread t3 = new Thread(new Mutex(mutex));
        t3.start();
        Thread t4 = new Thread(new Mutex(mutex));
        t4.start();
        Thread t5 = new Thread(new Mutex(mutex));
        t5.start();

    }
}
