
public class Gerente extends Funcionario {

	private int senha;

	public Gerente() {

	}

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do GERENTE");
		return super.getSalario();
	}

}
