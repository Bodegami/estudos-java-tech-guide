
public class TestaBanco {

	public static void main(String[] args) {
		
		Cliente renato = new Cliente();
		renato.nome = "renato";
		renato.cpf = "222.222.222-22";
		renato.profissao = "programador";
		
		Conta contaDoRenato = new Conta();
		contaDoRenato.deposita(100);
		
		// associa o cliente renato a conta contaDoRenato
		contaDoRenato.titular = renato;
		System.out.println(contaDoRenato.titular.nome);
		System.out.println(contaDoRenato.titular);
		
	}
	
}
