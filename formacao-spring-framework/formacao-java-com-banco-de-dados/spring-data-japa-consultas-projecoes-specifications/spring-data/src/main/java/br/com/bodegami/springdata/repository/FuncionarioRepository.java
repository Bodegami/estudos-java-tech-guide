package br.com.bodegami.springdata.repository;

import br.com.bodegami.springdata.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

}
