
public class TesteFuncionario {

	public static void main(String[] args) {

		Gerente nico = new Gerente();
		nico.setNome("nico steppat");
		nico.setCpf("223344556-67");
		nico.setSalario(2600.0);

		System.out.println(nico.getNome());
		System.out.println(nico.getBonificacao());
	}

}
