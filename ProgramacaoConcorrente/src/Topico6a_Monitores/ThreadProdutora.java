/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico6a_Monitores;

import java.util.Random;

/**
 *
 * @author jennifer
 */
public class ThreadProdutora extends Thread {

    public ThreadProdutora(Monitor monitor) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Random r = new Random();
                while (true) {
                    int t = r.nextInt(10);
                    try {
                        System.out.println("Produzi o valor " + t);
                        sleep(t*100);

                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

}
