
//Gerente é um Funcionario, Gerente herda da class Funcionario e
//assina o contrato Autenticavel, Gerente implementa a interface Autenticavel
public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;
	
	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
		
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
	
	@Override
	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do GERENTE");
		return super.getSalario();
	}

}
