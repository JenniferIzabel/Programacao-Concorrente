/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico7_Semaforo.Mutex;

/**
 *
 * @author jennifer
 */
public class BinarySemaphore {
    private boolean value;

    public BinarySemaphore(boolean value) {
        this.value = value;
    }
    
    public synchronized void P(){
        while(value == false){
            try{
                this.wait();
            }catch (InterruptedException ie){}
        }
        value = false;
    }
    
    public synchronized void V(){
        value = true;
        this.notify();
    }
    
}
