
public class Gerente extends Funcionario {

	@Override
	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do GERENTE");
		return super.getSalario();
	}

}
