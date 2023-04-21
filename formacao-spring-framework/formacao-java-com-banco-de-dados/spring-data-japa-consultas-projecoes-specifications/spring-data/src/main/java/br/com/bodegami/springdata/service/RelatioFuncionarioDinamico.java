package br.com.bodegami.springdata.service;

import br.com.bodegami.springdata.orm.Funcionario;
import br.com.bodegami.springdata.repository.FuncionarioRepository;
import br.com.bodegami.springdata.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatioFuncionarioDinamico {

    private final FuncionarioRepository repository;

    public RelatioFuncionarioDinamico(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite o nome: ");
        String nomeString = scanner.next();

        List<Funcionario> funcionarios = repository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }

}
