package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

    public static void main(String[] args) throws Exception {

        Class<?> subControleClasse =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");
        
      Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
      construtorPadrao.setAccessible(true);
    
      Object subControle = construtorPadrao.newInstance();

        
        for (Method m : subControleClasse.getMethods()) {
        	System.out.println(m);
        }
        
        System.out.println("\n--------------------><--------------------\n");
        
        for (Method m : subControleClasse.getDeclaredMethods()) {
        	System.out.println(m);
        }
        
        //Quando o metodo tem retorno, o invoke retorna Object
        //Quando o metodo tem retorno void, o invoke retorna null
        
        
        Method method = subControleClasse.getDeclaredMethod("metodoSubControle1");
        method.setAccessible(true);
        Object object = method.invoke(subControle);
        
        System.out.println(object);

    }
}