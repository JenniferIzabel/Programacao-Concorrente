/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico7_Semaforo.Multiplex;

/**
 *
 * @author jennifer
 */
public class CountingSemaphore {
    private int value;

    public CountingSemaphore(int value) {
        this.value = value;
    }
    
    public synchronized void P(){
        while(value == 0){
            try{
                this.wait();
            }catch (InterruptedException ie){}
        }
        value --;
    }
    
    public synchronized void V(){
        value ++;
        this.notify();
    }
    
}
