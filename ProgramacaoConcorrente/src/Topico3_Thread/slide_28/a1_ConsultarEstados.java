/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3_Thread.slide_28;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 * 
 * 
 * Faça um programa em Java que consulte periodicamente o
 * estado de um conjunto de threads.
 */
public class a1_ConsultarEstados implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(a1_ConsultarEstados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new a1_ConsultarEstados()); t1.start();

        while(t1.isAlive()){
            System.out.println("to viva");
            Thread.sleep(1000);
        }
    }
}
