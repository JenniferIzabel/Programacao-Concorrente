/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3_slide_6;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jennifer
 * 
 * 3.  Implemente o exemplo de código que gera a condição de
 * disputa e tente gerar um teste para que ocorra um problema
 * de segurança (safety).
 */
public class a3_ThreadSafety implements Runnable{
    
    Contador cont = new Contador();
    
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Digite a quantidade de Threads a serem criadas:");

        int qtd = scan.nextInt();  // Read user input
        
        for (int i = 0; i < qtd; i++) {
            criadora();
        }
        
        
    }

    private static void criadora() {
        new Thread (new a3_ThreadSafety()).start();
    }   

     @Override
    public void run() {
        this.cont.incrementaContador();
        System.out.println("Thread "+ this.cont.getContador());   
    }
}
    
    
    

