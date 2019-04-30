/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico6a_Monitores;

/**
 *
 * @author jennifer
 */
public class Monitor {
    private Buffer buffer;

    public Monitor() {
        this.buffer = new Buffer(5);
    }
    
    public synchronized void produz(int valor){
        this.buffer.addOnBuffer(valor);
        this.buffer.notify();
    }
    
    public synchronized int consome(){
        
        
        
        return 0;
    }
}
