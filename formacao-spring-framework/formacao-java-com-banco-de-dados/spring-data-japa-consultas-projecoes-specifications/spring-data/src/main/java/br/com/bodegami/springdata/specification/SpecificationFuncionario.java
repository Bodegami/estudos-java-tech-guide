package br.com.bodegami.springdata.specification;

import br.com.bodegami.springdata.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

}
