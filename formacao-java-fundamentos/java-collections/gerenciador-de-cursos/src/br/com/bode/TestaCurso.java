package br.com.bode;

public class TestaCurso {

	public static void main(String[] args) {
		
		/**
		 * 
		 * ArrayList:
		 *  Utiliza um array internamente, isso faz com que ele consiga recuperar um valor
		 * pelo indice muito rápido, graças ao conceito de "random access".
		 *  O problema de ArrayList é quando precisamos deletar ou inserir informações no meio 
		 * ou no começo da lista, isso pq por padrão o arrayList vai adicionar/remover o elemento
		 * e depois vai ajustar cada elemento posterior um a um, o que torna uma operaçao custosa.
		 * 
		 * 
		 * LinkedList:
		 *  O LinkedList já ao contrario do ArrayList, é muito bom para inserir ou remover elementos
		 * no meio ou no começo da lista, isso por conta da sua estrutura encadeada onde cada elemento
		 * tem um ponteiro para o proximo e o anterior, isso faz com que rapidamente o LinkedList 
		 * adicione ou remova elementos.
		 *  O problema é que o LinkedList não é bom para iterar sobre ele, isso porque caso seja preciso
		 * recuperar um elemento na posição 1000, o LinkedList vai verificar um por um até chegar no 
		 * elemento indicado. Além disso o LinkedList não usa a estrategia do "Random Access".
		 * 
		 */
		
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		//List<Aula> aulas = javaColecoes.getAulas();
		//System.out.println(aulas);
		
		
		//javaColecoes.getAulas().add(new Aula("Trabalhando com o ArrayList", 21));
		//System.out.println(aulas);
		javaColecoes.adiciona(new Aula("Trabalhando com o ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		System.out.println(javaColecoes.getAulas());
		
		//System.out.println(aulas == javaColecoes.getAulas());

	}

}
