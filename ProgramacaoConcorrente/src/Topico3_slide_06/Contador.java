/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3_slide_06;

/**
 *
 * @author Jennifer
 * 
 * Contador para o exercio da classe a3_ThreadSafety
 */
public class Contador {
    private int contador;
    
    public Contador(){
        this.contador = 1;
    }

    public int getContador() {
        return contador;
    }

    public int incrementaContador() {
        this.contador += 1;
        return this.contador;
    }
    
    
    
}
