/*
 * Implemente o problema do produtor-consumidor que h´a um
buffer compartilhado entre threads. H´a uma ´unica thread
produtora e uma ´unica consumidora. O buffer ´e preenchido
em tempos aleat´orios pela thread produtora. Assim que for
produzido algo, a thread consumidora deve ser comunicada
para obter o valor.and open the template in the editor.
 */
package Topico6a_Monitores;

/**
 *
 * @author jennifer
 */
public class ProdutorConsumidor {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Monitor monitor = new Monitor();
        ThreadProdutora produtor = new ThreadProdutora(monitor);
        ThreadConsumidora consumidor = new ThreadConsumidora(buffer);
    }
}
