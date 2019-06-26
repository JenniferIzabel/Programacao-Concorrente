/*
 * 2. Fa¸ca um programa que calcule a soma dos elementos de uma matriz
MxN. Divida o programa em tarefas que somam as linhas. O programa
deve possibilitar especificar o n´umero de threads para resolver o problema.
 */
package Topico10_Executor.Ex2;

import java.util.concurrent.Callable;

/**
 *
 * @author jennifer
 */
public class SomaLinhasMatrizTask implements Callable<Integer>{
    private int[] linha;

    public SomaLinhasMatrizTask(int[] linha) {
        this.linha = linha;
    }
    
    private int soma(){
        int soma = 0;
        for (int i = 0; i < linha.length; i++) {
            soma = soma + linha[i];
        }
        return soma;
    }
    
    
    @Override
    public Integer call() throws Exception {
        return soma();
    }

    
    
}