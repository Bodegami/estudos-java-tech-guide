
//Gerente é um Funcionario, Gerente herda da class Funcionario e
//assina o contrato Autenticavel, Gerente implementa a interface Autenticavel
public class Gerente extends Funcionario implements Autenticavel {

	private int senha;
	
	@Override
	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do GERENTE");
		return super.getSalario();
	}

	@Override
	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

}
