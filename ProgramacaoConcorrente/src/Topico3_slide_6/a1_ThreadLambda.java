/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3_slide_6;

/**
 *
 * @author Jennifer
 * 
 * 1. Implemente o exemplo anterior usando Lambda Expression.
 */
public class a1_ThreadLambda extends Thread {
    
    
    public static void main(String[] args) {
        new Thread( ()->{
            System.out.println("Print dentro da thread");
        }
        ).start();
    }
    
    
    
}
