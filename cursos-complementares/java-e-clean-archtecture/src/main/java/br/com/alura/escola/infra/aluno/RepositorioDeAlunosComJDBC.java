package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

	private final Connection connection;

	public RepositorioDeAlunosComJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			
			String sql = "SELECT * FROM ALUNO WHERE CPF = (?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getRegistro());
			ResultSet rs = ps.executeQuery();
			
			return new Aluno(new CPF(rs.getString("cpf")), 
								rs.getString("nome"), 
								new Email(rs.getString("email")));
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			
			String sql = "SELECT * FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Aluno> result = new ArrayList<>();
			
			while (rs.next()) {
				result.add(new Aluno(new CPF(rs.getString("cpf")),
							rs.getString("nome"),
							new Email(rs.getString("email"))));
				
			}
			
			return result;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
