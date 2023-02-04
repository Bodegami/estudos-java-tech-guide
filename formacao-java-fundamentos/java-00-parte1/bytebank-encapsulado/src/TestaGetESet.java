
public class TestaGetESet {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		//conta.numero = 1337;

		conta.setNumero(1337);
		System.out.println(conta.getNumero());
		
		Cliente renato = new Cliente();
		//conta.titular = renato;
		renato.setNome("renato");
		renato.setCpf(null);
		renato.setProfissao(null);
		
		conta.setTitular(renato);
		
		System.out.println(conta.getTitular().getNome());
		
		
		conta.getTitular().setProfissao("programador");
		//agora em duas linhas:
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfissao("programador");
		
		System.out.println(titularDaConta);
		System.out.println(renato);
		System.out.println(conta.getTitular());
		
		
	}

}
