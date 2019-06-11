/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico10_Tarefas.Fatorial;

/**
 *
 * @author jennifer
 */
public class FatorialRunnableTask implements Runnable {

    private int n;
    private int resultado;

    public FatorialRunnableTask(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        this.resultado = fact;
    }

    public int getResultado() {
        return resultado;
    }
    
    

}
