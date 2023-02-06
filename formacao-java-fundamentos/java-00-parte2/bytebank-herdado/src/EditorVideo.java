
public class EditorVideo extends Funcionario {

	public double getBonificacao() {
		System.out.println("chamando o metodo bonificacao do EDITOR VIDEO");
		return super.getBonificacao() + 100;
	}

}
