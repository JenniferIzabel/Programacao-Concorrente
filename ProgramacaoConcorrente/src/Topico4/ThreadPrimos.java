/*
 * 1. Faça um programa em Java que use Threads para encontrar
 * os números primos dentro de um intervalo. O método que
 * contabiliza os números primos deve possuir como entrada:
 * valor inicial e final do intervalo, números de threads
 */
package Topico4;

import java.util.List;

/**
 *
 * @author jennifer
 */
public class ThreadPrimos extends Thread {

    private List<Integer> listaPrimos;
    private Cursor cursor;

    ThreadPrimos(Cursor cursor, List<Integer> listaPrimos) {
        this.cursor = cursor;
        this.listaPrimos = listaPrimos;

    }

    @Override
    public void run() {
        verificarSePrimo(this.cursor.getNext());
    }

    private boolean verificarSePrimo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        listaPrimos.add(n);
        return true;
    }

}
