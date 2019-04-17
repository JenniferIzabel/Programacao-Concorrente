/*
 * Implemente o problema do produtor-consumidor que h´a um
buffer compartilhado entre threads. H´a uma ´unica thread
produtora e uma ´unica consumidora. O buffer ´e preenchido
em tempos aleat´orios pela thread produtora. Assim que for
produzido algo, a thread consumidora deve ser comunicada
para obter o valor.and open the template in the editor.
 */
package SinalizacaoEntreThreads;

import java.util.Random;

/**
 *
 * @author jennifer
 */
public class ProdutorConsumidor {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        ThreadProdutora produtor = new ThreadProdutora(buffer);
        ThreadConsumidora consumidor = new ThreadConsumidora(buffer);
    }
}

class Buffer {

    private Integer buf;

    public Integer getBuf() {
        return buf;
    }

    public void setBuf(int buf) {
        this.buf = buf;
    }

}

class ThreadProdutora extends Thread {

    Buffer buffer;

    public ThreadProdutora(Buffer buffer) {
        this.buffer = buffer;
        produzir();
    }

    private void produzir() {
        Random r = new Random();
        int t = r.nextInt(10);
        System.out.println("t: "+t);
        while (true) {
            try {
                //if (this.buffer.getBuf() != null) {
                    this.buffer.wait();
                //} else {
                    synchronized (buffer) {
                        this.buffer.setBuf(t);
                        this.buffer.notify();
                        System.out.println("Produzi o valor " + t);
                    }
                    sleep(t);
                //}
            } catch (Exception e) {
            }
        }
    }
}

class ThreadConsumidora extends Thread {

    Buffer buffer;

    public ThreadConsumidora(Buffer buffer) {
        this.buffer = buffer;

        System.out.println("CONSUMIDORA");
        while (true) {
            try {
               // if (this.buffer.getBuf() != null) {
                    synchronized (buffer) {
                        int v = this.buffer.getBuf();
                        this.buffer.notify();
                        System.out.println("Consumi o valor " + v);
                    }
               // } else {
                //    buffer.wait();
               // }
            } catch (Exception e) {
            }
        }
    }

}
