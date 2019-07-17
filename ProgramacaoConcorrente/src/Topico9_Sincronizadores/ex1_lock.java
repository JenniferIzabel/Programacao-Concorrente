/*
Faça um programa usando Lock para simular a atualização de
um contador que é acessado por múltiplas threads. O
contador pode diminuir e aumentar.
 */
package Topico9_Sincronizadores;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 * 
 * incrementa a cada 1,5 segundos e decrementa a cada 2
 * deve forma o contador aumenta aos poucos
 */
public class ex1_lock implements Runnable {

    private Contador contador;
    private Lock lock;
    private int sleepTime; // por quanto tempo a thread deve dormir
    private boolean funcao; // true incrementa, false decrementa

    public ex1_lock(Contador contador, Lock lock, boolean funcao) {
        this.contador = contador;
        this.lock = lock;
        this.funcao = funcao;
    }

    @Override
    public void run() {
        if (funcao) { // se for true incrementa
            sleepTime = 150;
            while (true) {
                lock.lock(); // pega o lock 
                try {
                    contador.incrementa();
                } finally {
                    lock.unlock(); // solta o lock
                }
                System.out.println("incrementa ->" + contador.getValor());
                dorme();
            }
        } else { // senão decrementa
            sleepTime = 200;
            while (true) {
                lock.lock(); // pega o lock
                try {
                    contador.decrementa();
                } finally {
                    lock.unlock(); // solta o lock
                }
                System.out.println("decrementa ->" + contador.getValor());
                dorme();
            }
        }
    }

    public void dorme() {
        try {// tenta dormir um pouquinho
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ex1_lock.class.getName()).log(Level.SEVERE.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        // objeto que guarda o valor a ser alterado pelas threads
        Contador contador = new Contador(0);
        
        //lock para permitir que somente uma thread acesse por vez
        Lock lock = new ReentrantLock();
        
        //thread para incrementar
        Thread t1 = new Thread(new ex1_lock(contador, lock, true)); t1.start();
        //thread para decrementar
        Thread t2 = new Thread(new ex1_lock(contador, lock, false)); t2.start();

    }
}
