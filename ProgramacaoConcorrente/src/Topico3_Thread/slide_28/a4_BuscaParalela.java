/*
Faça um programa em Java que realize uma busca paralela
em um vetor de inteiros. Informe para o método: valor
procurado, vetor de inteiros e o número de threads.
 */
package Topico3_Thread.slide_28;

import java.util.Scanner;

/**
 *
 * @author jennifer
 */
public class a4_BuscaParalela implements Runnable{
    int v[];
    int n;
    int inicio;
    int fim;

    public a4_BuscaParalela(int[]v, int n, int inicio, int fim) {
        this.v = v;
        this.n = n;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            if(v[i]== n){
                System.out.println("numero "+n+" encontrado na posição "+i);
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v[] = {5,543,4,17,5,24,14,75,67,1414,1,427,2,741,41};
        
        System.out.println("valor procurado: ");
        int procurado = sc.nextInt();
         
        System.out.println("numero de threads: ");
        int nthreads = sc.nextInt();
        
        int passo = v.length/nthreads;
        
        for (int i = 0; i < nthreads; i++) {
            int p = 0;
            if(i + passo > v.length) p = v.length; else p = passo;
            System.out.println("i: "+i);
            Thread ti = new Thread(new a4_BuscaParalela(v, procurado, i, i+p)); ti.start();
        }
    }
}
