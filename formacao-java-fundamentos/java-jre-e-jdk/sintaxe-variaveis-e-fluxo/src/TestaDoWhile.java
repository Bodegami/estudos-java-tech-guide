
public class TestaDoWhile {

	public static void main(String[] args) {
		
		// A principal diferenca entre while e do while, é que vai executar o bloco do do while ao menos uma vez
		int contador = 0;
		
		do {
			System.out.println(contador);
			contador++;			
		} while(contador <= 10);
	}
}
