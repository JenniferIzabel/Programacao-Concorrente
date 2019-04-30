/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.slide_17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 *
 * 1) Faça um programa em Java que inicie três threads e, cada thread, espere um
 * tempo aleatório para terminar.
 */
public class a1_TerminarTempoAleatorio extends Thread {

    static void dormir(int ms, int i) {
        try {
            System.out.println("Thread "+i+" vai dormir por " + ms + " milisegundos");
            sleep(ms);
            System.out.println("Thread "+i+" acordou!!");
        } catch (InterruptedException ex) {
            Logger.getLogger(a1_TerminarTempoAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        Random r = new Random();

        for (int i = 0; i < 3; i++) {
            int num = r.nextInt(10);
            final int ii = i;

            Thread t1 = new Thread(() -> {
                dormir(num*100, ii);
            });
            t1.start();

        }

    }

}
