
public class TesteSaca {

	public static void main(String[] args) {
		
		ContaCorrente conta = new ContaCorrente(123, 321);
		
		conta.deposita(200.0);
		
		try {
			conta.saca(210.0);
		} catch(Exception ex) {
			System.out.println("Ex: " +ex.getMessage());
		}
		
		System.out.println(conta.getSaldo());
	}

}
