package br.com.bodegami.springdata.repository;

import br.com.bodegami.springdata.orm.Funcionario;
;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

    //Metodo com Derived Query
    //List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate data);

    //Metodo com JPQL
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao = :data")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

    //Metodo com Native Query
    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);








    /**
     * Exemplos:
     *
     * List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
     * ou
     * @Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
     * List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
     *
     *
     * List<Funcionario> findByCargoDescricao(String descricao);
     * ou
     * @Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
     * List<Funcionario> findByCargoPelaDescricao(String descricao);
     *
     */

}
