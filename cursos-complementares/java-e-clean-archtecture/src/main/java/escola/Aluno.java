package escola;

import java.util.ArrayList;
import java.util.List;

//ENTIDADE
public class Aluno {

	private String cpf;
	private String nome;
	
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	public void adicionarTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}
	
}
