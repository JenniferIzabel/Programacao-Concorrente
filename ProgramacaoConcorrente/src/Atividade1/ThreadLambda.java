/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade1;

/**
 *
 * @author Jennifer
 * 
 * 1. Implemente o exemplo anterior usando Lambda Expression.
 */
public class ThreadLambda extends Thread {
    
    public ThreadLambda(){
        new Thread( ()->{
            System.out.println("print dentro da thread");
        }
        ).start();
    }
    
}
