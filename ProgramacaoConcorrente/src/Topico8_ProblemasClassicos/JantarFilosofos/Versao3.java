package Topico8_ProblemasClassicos.JantarFilosofos;


/*
Temporizacao para pegar qualquer garfo: no maximo numero
de filosofos - 1 devem esperar um tempo.
*/

import java.util.concurrent.Semaphore;

public class Versao3 implements Garfo {

    int n = 0;
    Semaphore[] fork = null;

    public Versao3(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pegarGarfo(int i) throws InterruptedException {
        try {

            while(!fork[i].tryAcquire()) { // espera um tempo se nao conseguir pegar o garfo
                Thread.sleep(5000);
            }

            while(!fork[(i + 1) % n].tryAcquire()) {
                Thread.sleep(5000);
            }

        } catch (InterruptedException ex) {
            // libera os dois, caso tenha pegado algum
            fork[i].release();
            fork[(i+1)%n].release();
            throw new InterruptedException();
        }
    }

    @Override
    public void soltarGarfo(int i) throws InterruptedException {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        Versao3 philosopher = new Versao3(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new JantarFilosofos(i, philosopher, 3)).start();
        }
    }
}
