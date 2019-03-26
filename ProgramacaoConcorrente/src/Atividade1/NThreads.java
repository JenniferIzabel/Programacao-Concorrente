/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jennifer
 *
 * 2.  Fa ̧ca um programa que receba um valor indicando um n ́umero
de threads a serem instanciadas e teste os dois modos de criar
threads em Java.
* dica:  use o
Thread.sleep
para pausar as threads por um
intervalo de tempo.
 */
public class NThreads implements Runnable {

    private int n;

    @Override
    public void run() {
        System.out.println("de fora");
        criadora();
    }

    public NThreads(int n) {
        new Thread(new NThreads(n)).start();

    }
    
    private void criadora(){
        new Thread( ()->{
            System.out.println("print dentro da thread");
        }
        ).start();
    }

}
