
public class Gerente extends FuncionarioAutenticavel {

	@Override
	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do GERENTE");
		return super.getSalario();
	}

}
