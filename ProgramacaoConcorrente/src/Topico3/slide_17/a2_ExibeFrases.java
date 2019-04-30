/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.slide_17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jennifer
 *
 * 2) Faça uma thread Java que realize a leitura de um arquivo texto com frases
 * e exiba as frases a cada 10 segundos.
 */
public class a2_ExibeFrases implements Runnable {

    public static void main(String[] args) {
        new Thread(new a2_ExibeFrases()).start();
    }

    @Override
    public void run() {
        try {

            BufferedReader br = new BufferedReader(new FileReader("/home/jennifer/Documents/UTFPR/2019-1/Programação Concorrente/Programacao-Concorrente/ProgramacaoConcorrente/src/Topico3_slide_17/texto.txt"));
            String strLine;
            
            while ((strLine = br.readLine()) != null) {//Read File Line By Line
                System.out.println(strLine);
                dormir(1000); //10000 = 10s
           
            }
            
            br.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        

    }

    static void dormir(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(a2_ExibeFrases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
