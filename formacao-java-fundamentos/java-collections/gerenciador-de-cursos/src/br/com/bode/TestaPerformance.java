package br.com.bode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {
    	
    	System.out.println("Testando com ArrayList: ");

        Collection<Integer> numeros = new ArrayList<Integer>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto: " + tempoDeExecucao);
        
        System.out.println("-----------------------------------------");

    	System.out.println("Testando com HashSet: ");

    	Collection<Integer> numerosHash = new HashSet<>();

        long inicioHash = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
        	numerosHash.add(i);
        }

        for (Integer numero : numerosHash) {
        	numerosHash.contains(numero);
        }

        long fimHash = System.currentTimeMillis();

        long tempoDeExecucaoHash = fimHash - inicioHash;

        System.out.println("Tempo gasto: " + tempoDeExecucaoHash);
        
    }

}
