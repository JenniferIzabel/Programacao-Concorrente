package Topico8_ProblemasClassicos.JantarFilosofos;


/*
Pegar ambos garfos: atomicamente garantir que um filosofo
pega os dois garfos simultaneamente.
*/


import java.util.concurrent.Semaphore;

public class Versao2 implements Garfo {

    int n = 0;
    Semaphore[] fork = null;

    public Versao2(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pegarGarfo(int i) throws InterruptedException {
        try {

            if(!fork[i].tryAcquire()) {             // se nao conseguir pegar o garfo
                throw new InterruptedException();   // lança uma exceçao
            }

            if(!fork[(i + 1) % n].tryAcquire()) {
                throw new InterruptedException();
            }

        } catch (InterruptedException ex) {
            // libera os dois, caso tenha pegado algum
            fork[i].release();
            fork[(i+1)%n].release();
            throw new InterruptedException();
        }
    }

    @Override
    public void soltarGarfo(int i) throws InterruptedException {   // apenas solta os dois garfos
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        Versao2 philosopher = new Versao2(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new JantarFilosofos(i, philosopher, 2)).start();
        }
    }
}
