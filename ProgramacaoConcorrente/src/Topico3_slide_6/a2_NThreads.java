/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3_slide_6;

import com.sun.tools.jdeprscan.scan.Scan;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jennifer
 *
 * 2. Faça um programa que receba um valor indicando um número de threads a
 * serem instanciadas e teste os dois modos de criar threads em Java. dica: use
 * o Thread.sleep para pausar as threads por um intervalo de tempo.
 */
public class a2_NThreads implements Runnable {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("Digite a quantidade de Threads a serem criadas:");

        int qtd = scan.nextInt();  // Read user input
        
        for (int i = 0; i < qtd; i++) {
            criadora();
        }
        
        
    }


    private static void criadora() {
        new Thread (new a2_NThreads()).start(); ;
    }

    @Override
    public void run() {
        System.out.println("Print dentro da thread");   
    }

}
