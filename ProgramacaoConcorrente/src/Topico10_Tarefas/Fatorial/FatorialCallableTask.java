/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico10_Tarefas.Fatorial;

import java.util.concurrent.Callable;

/**
 *
 * @author jennifer
 */
public class FatorialCallableTask implements Callable<Integer>{
    int n;

    public FatorialCallableTask(int n) {
        this.n = n;
    }
    
    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    
}
