/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico6a_Monitores;

import Topico6_SinalizacaoEntreThreads.*;
import static java.lang.Thread.sleep;

/**
 *
 * @author jennifer
 */
public class ThreadConsumidora extends Thread {

    private int old;
    private int valor;

    public ThreadConsumidora(Buffer buffer) {
        System.out.println("CONSUMIDORA");
        new Thread(new Runnable() {
            @Override
            public void run() {
                old = buffer.getIndexConsumidora();
                while (true) {
                    System.out.println("index: "+ buffer.getIndexConsumidora());
                    try {
                        if (old == buffer.getIndexProdutora()) {
                           buffer.wait();
                        } else {
                            synchronized (buffer) {
                                valor = buffer.getBufferI();
                                buffer.notify();
                            }
                            System.out.println("Consumi o valor " + valor);
                            old = buffer.getIndexConsumidora();
                            sleep(valor*99);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }
}
