/*
Faça um programa em Java com threads que exiba os
números primos entre 0 e 100000
 */
package Topico3_Thread.slide_28;

/**
 *
 * @author jennifer
 */
public class a3_NumerosPrimos implements Runnable {

    private int inicio;
    private int fim;

    public a3_NumerosPrimos(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fim; i++) {
            if (primo(i)) {
                System.out.println(i);
            }
        }
    }

   
    public boolean primo(int number) {
         number = Math.abs(number);
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    

    public static void main(String[] args) {

        Thread t1 = new Thread(new a3_NumerosPrimos(1, 10));
        t1.start();
        Thread t2 = new Thread(new a3_NumerosPrimos(11, 20));
        t2.start();
        Thread t3 = new Thread(new a3_NumerosPrimos(21, 30));
        t3.start();
        Thread t4 = new Thread(new a3_NumerosPrimos(31, 40));
        t4.start();
        Thread t5 = new Thread(new a3_NumerosPrimos(41, 50));
        t5.start();

    }
}
