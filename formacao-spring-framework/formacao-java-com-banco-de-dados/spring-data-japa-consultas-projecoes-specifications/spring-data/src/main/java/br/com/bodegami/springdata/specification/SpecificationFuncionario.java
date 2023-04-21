package br.com.bodegami.springdata.specification;

import br.com.bodegami.springdata.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFuncionario {

    //consulta pelo criterio de like por nome
    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    //consulta pelo criterio de igualdade por cpf
    public static Specification<Funcionario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    //consulta pelo criterio de maior ou igual ao salario informado
    public static Specification<Funcionario> salario(Double salario) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("salario"), salario);
    }

    //consulta pelo criterio de maior que a data de contratacao informada
    public static Specification<Funcionario> dataContratacao(LocalDate data) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("nome"), data);
    }

}
