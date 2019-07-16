package Topico8_ProblemasClassicos.JantarFilosofos;

/*
Introduzir assimetria: obrigar um filosofo a pegar em diferente ordem.
 */
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Versao1 implements Garfo {

    int n = 0;
    Semaphore[] fork = null;
    Random ordem;

    public Versao1(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }

        ordem = new Random();
    }

    @Override
    public void pegarGarfo(int i) throws InterruptedException {

        int primeiro;
        int segundo;

        if (ordem.nextInt(2) == 0) {
            primeiro = i;
            segundo = (i + 1) % n;
        } else {
            primeiro = (i + i) % n;
            segundo = i;
        }

        fork[primeiro].acquire();
        fork[segundo].acquire();
    }

    @Override
    public void soltarGarfo(int i) throws InterruptedException {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        Versao1 philosopher = new Versao1(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new JantarFilosofos(i, philosopher, 1)).start();
        }
    }
}
