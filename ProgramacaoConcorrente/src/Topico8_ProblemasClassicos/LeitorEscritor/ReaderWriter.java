/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico8_ProblemasClassicos.LeitorEscritor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author jennifer
 */
public class ReaderWriter {

    int numReader = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore wlock = new Semaphore(1);

    public void startRead() throws InterruptedException {
        mutex.acquire();
        numReader++;
        if (numReader == 1) {
            wlock.acquire();// se tiver alguem escrevendo, bloqueia a leitura
        }
        mutex.release();
    }

    public void endRead() throws InterruptedException {
        mutex.acquire();
        numReader--;
        if (numReader == 0) {
            wlock.release();// se não tiver ninguem lendo, pode escrever
        }
        mutex.release();

    }

    public void startWrite() throws InterruptedException {
        wlock.acquire();

    }

    public void endWrite() {
        wlock.release();
    }

}

class rw {

    int size = 5;
    double[] buffer = new double[size];

    public void ler() {

    }
}
