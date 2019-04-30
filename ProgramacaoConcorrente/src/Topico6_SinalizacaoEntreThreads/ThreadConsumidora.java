/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico6_SinalizacaoEntreThreads;

/**
 *
 * @author jennifer
 */
public class ThreadConsumidora extends Thread {

    Buffer buffer;

    public ThreadConsumidora(Buffer buffer) {
        this.buffer = buffer;

        new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (true) {
                    try {
                        if (ThreadConsumidora.this.buffer.getBuf() != null) {
                            synchronized (ThreadConsumidora.this.buffer) {
                                int v = ThreadConsumidora.this.buffer.getBuf();
                                System.out.println("Consumi o valor " + v + "! Notify");
                                ThreadConsumidora.this.buffer.setBuf(null);
                                ThreadConsumidora.this.buffer.notify();
                            }
                        } else {
                            buffer.wait();
                        }
                    }catch (Exception e) {
                    }
                }
            }
        }).start();
    }
}
