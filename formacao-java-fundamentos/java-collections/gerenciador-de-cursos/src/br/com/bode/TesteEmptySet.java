package br.com.bode;

import java.util.Collections;
import java.util.Set;

public class TesteEmptySet {

    public static void main(String[] args) {

        Set<String> nomes = Collections.emptySet();
        nomes.add("Paulo"); //o que acontece aqui?
        
        //Retorna um excecao, pois o EmptySet segue a mesma ideia do Collections.unmodifiableCollection()
        
    }

}
