/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.slide_17;

import java.util.Scanner;

/**
 *
 * @author jennifer
 *
 * Faça uma Thread que monitora um conjunto de threads e exiba quais threads
 * receberam sinais de interrupção
 */
public class a4_MonitorarInterrupcao implements Runnable {
    
    

    @Override
    public void run() {
        System.out.println(":)");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread tMonitora = new Thread(new a4_MonitorarInterrupcao());
        tMonitora.start();

        Thread t1 = new Thread(new a4_MonitorarInterrupcao()); t1.start();
        Thread t2 = new Thread(new a4_MonitorarInterrupcao()); t2.start();
        Thread t3 = new Thread(new a4_MonitorarInterrupcao()); t3.start();
        
        t2.sleep(2000);
        t1.sleep(1000);
        t2.sleep(1500);

    }

}
