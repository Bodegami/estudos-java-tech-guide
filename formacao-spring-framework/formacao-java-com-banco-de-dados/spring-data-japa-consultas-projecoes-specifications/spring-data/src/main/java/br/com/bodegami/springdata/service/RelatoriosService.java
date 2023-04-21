package br.com.bodegami.springdata.service;

import br.com.bodegami.springdata.orm.Funcionario;
import br.com.bodegami.springdata.orm.FuncionarioProjecao;
import br.com.bodegami.springdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository repository;

    public RelatoriosService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de RELATORIOS deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");
            System.out.println("2 - Busca funcionario nome, data contratacao e salario maior");
            System.out.println("3 - Busca funcionario nome data contratacao");
            System.out.println("4 - Pesquisa funcionario salario");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
                    break;
                case 4:
                    pesquisarFuncionarioSalario();
                    break;
                default:
                    system = false;
                    break;
            }

        }

    }

    private void buscaFuncionarioNome(Scanner scanner) {

        System.out.println("Digite o nome:");
        String nome = scanner.next();

        List<Funcionario> lista = repository.findByNome(nome);
        lista.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();

        System.out.println("Qual data contratacao deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisar:");
        Double salario = scanner.nextDouble();

        List<Funcionario> lista = repository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        lista.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner) {
        System.out.println("Qual data contratacao deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> lista = repository.findDataContratacaoMaior(localDate);
        lista.forEach(System.out::println);
    }

    private void pesquisarFuncionarioSalario() {
        List<FuncionarioProjecao> lista = repository.findFuncionarioSalario();
        lista.forEach(f -> System.out.printf("Funcionario: id: %d | nome: %s | salario: %.2f \n",
                f.getId(), f.getNome(), f.getSalario()));
    }

}
