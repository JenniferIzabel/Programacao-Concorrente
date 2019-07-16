/*
 *Fa¸ca um programa usando Threads e ConcurrentMap para
calcular a frequˆencia de cada letra em um texto.
 */
package Topico11_Colecoes.ConcurrentMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author jennifer
 */
public class ConcurrentMap {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/jennifer/Documents/UTFPR/2019-1/Programação Concorrente/Programacao-Concorrente/ProgramacaoConcorrente/src/Topico11_Colecoes/ConcurrentMap/texto.txt");
        Scanner sc = new Scanner(file);

        // we just need to use \\Z as delimiter 
        //(pra pegar cada caracter do arquivo)
        sc.useDelimiter("\\Z");
        String c;
        
        do {
            c = sc.next();

        } while (!sc.equals("EOF"));

        ConcurrentHashMap concurrentMap = new ConcurrentHashMap();

        concurrentMap.put("key", "value");

        Object value = concurrentMap.get("key");
    }
}
