/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico4;

/**
 *
 * @author jennifer
 */
public class Cursor {
    
     private int inicio, fim, cursor;

    public Cursor(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
        this.cursor = 0;
    }
   
    public synchronized int getNext(){
        if(cursor < fim){
            return cursor ++;
        }
        return -1;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public int getCursor() {
        return cursor;
    }
      
    
    
    
}
