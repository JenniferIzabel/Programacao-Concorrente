/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico8_ProblemasClassicos.JantarFilosofos;


/*
garantir que um filosofo pegsempre os dois garfos ou nenhum

 *
 * @author jennifer
 */

import java.util.concurrent.Semaphore;

public class Versao2 extends Thread{
    
    @Override
    public void run(){
        
    }
}
//    int n = 0;
//    Semaphore[] fork = null;
//
//    public Versao2(int initN) {
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
//            if(!fork[i].tryAcquire()) {             
//                throw new InterruptedException();   
//            }
//
//            if(!fork[(i + 1) % n].tryAcquire()) {
//                throw new InterruptedException();
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
//
//}
