/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico6_SinalizacaoEntreThreads;

import java.util.Random;

/**
 *
 * @author jennifer
 */
public class ThreadProdutora extends Thread {

    Buffer buffer;

    public ThreadProdutora(Buffer buffer) {
        this.buffer = buffer;

        new Thread(new Runnable() {
            @Override
            public void run() {
                
                Random r = new Random();
                while (true) {
                    int t = r.nextInt(10);
                    try {
                        if (ThreadProdutora.this.buffer.getBuf() != null) {
                            ThreadProdutora.this.buffer.wait();
                        } else {
                            synchronized (ThreadProdutora.this.buffer) {
                                ThreadProdutora.this.buffer.setBuf(t);
                                ThreadProdutora.this.buffer.notify();
                                System.out.println("Produzi o valor " + t + "! Notify");
                            }
                            sleep(t);
                        }
                    }catch (Exception e) {
                    }
                }
            }
        }).start();
    }

}
