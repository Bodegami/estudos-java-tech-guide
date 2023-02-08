package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteBiblioteca {
	
	/*
	 * GERANDO UM .JAR:
	 * 1 - clicamos com o botao direito na raiz do projeto e selecionamos o 'export'
	 * 2 - depois selecionar java -> JAR file
	 * 3 - selecionar o que deseja importar. ex: src, docs, .classpath e etc
	 * 4 - avançamos e devemos apontar o nome e o destino do .jar
	 * 5 - se a intenção for criar apenas uma lib, podemos clicar em finish e estará disponivel para usar.
	 * 6 - se a intenção for criar um .jar executavel, clicamos em 'next' e depois 'next' novamente.
	 * 7 - agora precisamos definir qual entry-point desse .jar, ou seja, qual arquivo main que ele deve executar.
	 * 8 - pronto!
	 * 
	 * 
	 * EXECUTANDO UM .JAR:
	 * 1 - atraves do terminal, vamos até o diretorio onde está o .jar.
	 * 2 - agora executamos o comando: java -jar <nome_do_jar>.jar
	 * 3 - pronto! A saida do será impressa no terminal.
	 * 
	 * 
	 * IMPORTANDO UMA LIB:
	 * 1 - criar um diretorio chamado 'lib'
	 * 2 - copiar o .jar para dentro do diretorio 'lib'
	 * 3 - adicionar o .jar ao buildpath
	 * 4 - pronto!
	 * 
	 */

	public static void main(String[] args) {
		
		Conta c = new ContaCorrente(123, 321);
		
		c.deposita(200.3);
		
		System.out.println(c.getSaldo());

	}

}
