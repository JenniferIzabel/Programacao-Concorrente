/*
 * 1. Faça um programa em Java que use Threads para encontrar
 * os números primos dentro de um intervalo. O método que
 * contabiliza os números primos deve possuir como entrada:
 * valor inicial e final do intervalo, números de threads
 */
package Topico4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jennifer
 */
public class a1_NumerosPrimos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\ninicio do intervalo: ");
        int inicio = sc.nextInt();
        
        System.out.print("\nfim do intervalo: ");
        int fim = sc.nextInt();
        
        System.out.print("\nqtd de threads: ");
        int qtd = sc.nextInt();
        
        
        List<Integer> listaPrimos = new ArrayList<>();
        Cursor cursor = new Cursor(inicio, fim);
        ThreadPrimos threadPrimos;
            
        for (int i = 0; i < qtd; i++) {
            new ThreadPrimos(cursor, listaPrimos);
        }
        
        while(cursor.getCursor() <= cursor.getFim()){
            
            
        }
        
        System.out.println(listaPrimos);

    }
    
}
