/*
 * 5. Faça uma thread Java que fica aguardando uma sequência
numérica de tamanho arbitrário digitado por usuário para
realizar uma soma. Use o join().
 */
package Topico3_Thread.slide_17;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jennifer
 */
public class a5_SomaSequencia implements Runnable{

    @Override
    public void run() {
        Random r = new Random();
        int x = r.nextInt(10 + 1) + 10; // [0...10] + 10 = [10...20]
        Scanner sc = new Scanner(System.in);
        int soma = 0;
        for (int i = 0; i < x; i++) {
            System.out.println("Digite um numero");
            soma = soma + sc.nextInt();
        }
        System.out.println("Soma: "+soma);
        
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new a5_SomaSequencia()); 
        t1.start();
        t1.join(); // waiting t1 finish to continue
        
    }
}
