package br.com.bodegami.springdata.service;

import br.com.bodegami.springdata.orm.Funcionario;
import br.com.bodegami.springdata.repository.FuncionarioRepository;
import br.com.bodegami.springdata.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatioFuncionarioDinamico {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository repository;

    public RelatioFuncionarioDinamico(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite o NOME para fazer a consulta ou NULL para ir para o proximo criterio de busca: ");
        String nome = scanner.next();

        if (nome.equalsIgnoreCase("NULL")) {
            nome = null;
        }

        System.out.println("Digite o CPF para fazer a consulta ou NULL para ir para o proximo criterio de busca: ");
        String cpf = scanner.next();

        if (cpf.equalsIgnoreCase("NULL")) {
            cpf = null;
        }

        System.out.println("Digite o SALARIO para fazer a consulta ou 0 para ir para o proximo criterio de busca: ");
        Double salario = scanner.nextDouble();

        if (salario == 0) {
            salario = null;
        }

        System.out.println("Digite a DATA DE CONTRATACAO para fazer a consulta ou 0 para ir para o proximo criterio de busca: ");
        String data = scanner.next();

        LocalDate dataContratacao;
        if (data.equalsIgnoreCase("NULL")) {
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, formatter);
        }

        List<Funcionario> funcionarios = repository.findAll(Specification
                .where(SpecificationFuncionario.nome(nome))
                    .or(SpecificationFuncionario.cpf(cpf))
                    .or(SpecificationFuncionario.salario(salario))
                    .or(SpecificationFuncionario.dataContratacao(dataContratacao))
        );

        funcionarios.forEach(System.out::println);
    }

}
