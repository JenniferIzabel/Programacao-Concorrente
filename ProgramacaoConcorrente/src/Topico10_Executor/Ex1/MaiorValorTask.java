/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico10_Executor.Ex1;

import java.util.concurrent.Callable;

/**
 *
 * @author jennifer
 */
public class MaiorValorTask implements Callable<Integer>{

    private int lista[];
    private int maior, inicio, fim;
    
    public MaiorValorTask(int[] lista, int inicio, int fim) {
        this.lista = lista;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    private int maiorSublista(){
        int m = this.lista[this.inicio];
        if(this.fim > lista.length){this.fim = lista.length;}
        
        for (int i = this.inicio; i < this.fim; i++) {
            if(this.lista[i] > m){
                m = this.lista[i];
            } 
        }
        return m;
    }

    @Override
    public Integer call() throws Exception {
        return maiorSublista();
    }

    
    
}