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
 * 3.  Implemente o exemplo de código que gera a condição de
 * disputa e tente gerar um teste para que ocorra um problema
 * de segurança (safety).
 */
public class ThreadSafety extends Thread {
    
    Contador cont = new Contador();
    
    public ThreadSafety(){
        for (int i = 1; i < 10; i++) {
            System.out.println("i "+i);
            new Thread( ()->{
                System.out.println("cont "+cont.incrementaContador());
        }
        ).start();
        }
    }
    
   
    }
    
    
    

