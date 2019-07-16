/*
 *Fa¸ca um programa usando Threads e ConcurrentMap para
calcular a frequˆencia de cada letra em um texto.
 */
package Topico11_Colecoes.ConcurrentMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author jennifer
 */
public class ConcurrentMap {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ConcurrentHashMap concurrentMap = new ConcurrentHashMap();

        File file = new File("/home/jennifer/Documents/UTFPR/2019-1/Programação Concorrente/Programacao-Concorrente/ProgramacaoConcorrente/src/Topico11_Colecoes/ConcurrentMap/texto.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line = bufferedReader.readLine();

        while (line  != null) { //para cada linha do arquivo
            line = line.trim();
            for (int i = 0; i < line.length(); i++) {// para cada letra da linha
                char letra = line.charAt(i); 
                
                Object b = concurrentMap.putIfAbsent(letra, 1); // tenta colocar
                if (b == null) {// se não conseguir ++
                    int v = (int) concurrentMap.get(letra);
                   // System.out.println(v);
                    concurrentMap.replace(letra, v + 1);
                }else{
                    concurrentMap.put(letra, 1);
                }
            }
            line = bufferedReader.readLine();
        }

        for (Object key : concurrentMap.keySet()) {
            System.out.println(key + " " + concurrentMap.get(key));
        }
    }
}
