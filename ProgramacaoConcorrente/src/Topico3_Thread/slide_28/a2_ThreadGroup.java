/*
Faça um programa em Java para testar um conjunto de
operações sobre um grupo de threads. Use o ThreadGroup.
 */
package Topico3_Thread.slide_28;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 */
public class a2_ThreadGroup implements Runnable{

   @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(a1_ConsultarEstados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("grupin");

        Thread t1 = new Thread(group, "t1"); t1.start();
        Thread t2 = new Thread(group, "t2"); t2.start();
        Thread t3 = new Thread(group, "t3"); t3.start();
        
        System.out.println("prioridade: "+ group.getMaxPriority());
        group.setMaxPriority(1);
        System.out.println("prioridade: "+ group.getMaxPriority());


    }
}
