/*
 * 4. Multiplex
Garantir acesso à seção crítica para no máximo N threads.
Faça um código que possibilite que N threads estejam na seção crítica simultaneamente
 */
package Topico7_Semaforo.Multiplex;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class Multiplex extends Thread{
    
    CountingSemaphore multiplex;
    int cont = 0;

    Multiplex(CountingSemaphore multiplex) {
        this.multiplex = multiplex;
    }

    @Override
    public void run() {
            while (true) {
                try {
                    multiplex.P();
                    System.out.println("cont: " + ++cont);
                    Thread.sleep(1000);
                    multiplex.V();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Multiplex.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       
    }

    public static void main(String[] args) {
        CountingSemaphore multiplex = new CountingSemaphore(3);

        Thread t1 = new Thread(new Multiplex(multiplex));
        t1.start();
        Thread t2 = new Thread(new Multiplex(multiplex));
        t2.start();
        Thread t3 = new Thread(new Multiplex(multiplex));
        t3.start();
        Thread t4 = new Thread(new Multiplex(multiplex));
        t4.start();
        Thread t5 = new Thread(new Multiplex(multiplex));
        t5.start();
        Thread t6 = new Thread(new Multiplex(multiplex));
        t6.start();
        Thread t7 = new Thread(new Multiplex(multiplex));
        t7.start();
        Thread t8 = new Thread(new Multiplex(multiplex));
        t8.start();

    }
    
}
