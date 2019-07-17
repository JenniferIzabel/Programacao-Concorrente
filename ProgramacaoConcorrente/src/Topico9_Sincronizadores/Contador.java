/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico9_Sincronizadores;

/**
 *
 * @author jennifer
 */
public class Contador {
    private int valor;

    public Contador(int valor) {
        this.valor = valor;
    }

    
    public int incrementa() {
        return this.valor ++;
    }
    public int decrementa() {
        return this.valor --;
    }

    public int getValor() {
        return valor;
    }
    
   
    
    
    
    
}
