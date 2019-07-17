/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico8_ProblemasClassicos.JantarFilosofos;

/*
obrigar um filosofo a pegar em ordem diferente.
 */
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author jennifer
 */
public class Versao1 extends Thread{
    
    @Override
    public void run(){
        
    }
}

//public class Versao1 implements Garfo {
//    int n = 0;
//    Semaphore[] fork = null;
//    Random ordem;
//
//    public Versao1(int initN) {
//        n = initN;
//        fork = new Semaphore[n];
//        for (int i = 0; i < n; i++) {
//            fork[i] = new Semaphore(1);
//        }
//
//        ordem = new Random();
//    }
//
//    @Override
//    public void pegarGarfo(int i) throws InterruptedException {
//
//        int primeiro;
//        int segundo;
//
//        if (ordem.nextInt(2) == 0) {
//            primeiro = i;
//            segundo = (i + 1) % n;
//        } else {
//            primeiro = (i + i) % n;
//            segundo = i;
//        }
//
//        fork[primeiro].acquire();
//        fork[segundo].acquire();
//    }
//
//    @Override
//    public void soltarGarfo(int i) throws InterruptedException {
//        fork[i].release();
//        fork[(i + 1) % n].release();
//    }
//
//}
