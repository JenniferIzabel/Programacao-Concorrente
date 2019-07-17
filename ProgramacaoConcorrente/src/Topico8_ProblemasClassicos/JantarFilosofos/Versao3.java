/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico8_ProblemasClassicos.JantarFilosofos;


/*
Temporizacao para pegar qualquer garfo: no maximo numero
de filosofos - 1 devem esperar um tempo.
 *
 * @author jennifer
 */
import java.util.concurrent.Semaphore;

public class Versao3 extends Thread{
    
    @Override
    public void run(){
        
    }
}
//    int n = 0;
//    Semaphore[] fork = null;
//
//    public Versao3(int initN) {
//        n = initN;
//        fork = new Semaphore[n];
//        for (int i = 0; i < n; i++) {
//            fork[i] = new Semaphore(1);
//        }
//    }
//
//    @Override
//    public void pegarGarfo(int i) throws InterruptedException {
//        try {
//
//            while(!fork[i].tryAcquire()) { 
//                Thread.sleep(5000);
//            }
//
//            while(!fork[(i + 1) % n].tryAcquire()) {
//                Thread.sleep(5000);
//            }
//
//        } catch (InterruptedException ex) {
//            fork[i].release();
//            fork[(i+1)%n].release();
//            throw new InterruptedException();
//        }
//    }
//
//    @Override
//    public void soltarGarfo(int i) throws InterruptedException {
//        fork[i].release();
//        fork[(i + 1) % n].release();
//    }


