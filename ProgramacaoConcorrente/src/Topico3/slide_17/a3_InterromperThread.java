/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.slide_17;

import Topico3.slide_06.a3_ThreadSafety;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 *
 * 3) Faça um programa Java que envia interrupções para as threads dos
 * exercı́cios anteriores. As threads devem fazer o tratamento dessas
 * interrupções e realizar uma finalização limpa.
 */
public class a3_InterromperThread implements Runnable {

    public static void main(String[] args) {
        
        System.out.println("Para parar, aperte Enter:");

        Thread t = new Thread(new a3_InterromperThread());
        t.start();

        Scanner scan = new Scanner(System.in); 
        scan.nextLine();

        t.interrupt();

    }

    @Override
    public void run() {
        int i = 0;
        while (true) {

            try {
                
                Thread.sleep(1000);
                System.out.println(i++);

            } catch (InterruptedException ex) {
                System.out.println("PAROU");
                break;
            }

        }
    }

}
