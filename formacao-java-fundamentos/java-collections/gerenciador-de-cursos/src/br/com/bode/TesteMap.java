package br.com.bode;

import java.util.*;
import java.util.Map.Entry;

public class TesteMap {

    public static void main(String[] args) {

        Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);
        
        //Para acessar as chaves devemos executar:
        Set<String> chaves = nomesParaIdade.keySet();    
        for (String nome : chaves) {
            System.out.println(nome);
        }
        
        //E para pegar os valores usamos:
        Collection<Integer> valores = nomesParaIdade.values();
        for (Integer idade : valores) {
            System.out.println(idade);
        }
        
        /**
         *  Agora só falta a terceira coleção que devolve a associação.
         *  Para tal, existe o método entrySet() e cada associação é representado através da classe Entry:
         *  
         *  Repare que o método devolve um Set de Entry (respire fundo!!). 
         *  Para acessar essa coleção basta usar o foreach:
         */
        Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();    
        for (Entry<String, Integer> associacao : associacoes) {
            System.out.println(associacao.getKey() + " - " + associacao.getValue());
        }
        
    }
}
