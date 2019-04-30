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
public class Buffer {

    private int nElements;
    private int[] buffer;
    private int indexProdutora;
    private int indexConsumidora;

    public Buffer(int bufSize) {
        this.buffer = new int[bufSize];
        this.indexProdutora = 0;
        this.indexConsumidora = 0;
        this.nElements = 0;
    }
    
    public boolean isEmpty(){
        return nElements == 0;
    }
    
    public boolean isFull(){
        return nElements == buffer.length;
    }


    public int[] getBuffer() {
        if (this.indexConsumidora >= buffer.length) {
            this.indexConsumidora = 0;
        }
        this.indexConsumidora++;
        return this.buffer;
    }

    public int getBufferI() {
        if (this.indexConsumidora >=  buffer.length) {
            this.indexConsumidora = 0;
        }
        return this.buffer[this.indexConsumidora++];
    }

    public int addOnBuffer(Integer num) {
        if (this.indexProdutora >=  buffer.length) {
            this.indexProdutora = 0;
        }
        this.buffer[this.indexProdutora] = num;
        this.indexProdutora++;
        return this.indexProdutora;
    }

    public int getIndexProdutora() {
        return indexProdutora;
    }

    public int getIndexConsumidora() {
        return indexConsumidora;
    }

    
}
