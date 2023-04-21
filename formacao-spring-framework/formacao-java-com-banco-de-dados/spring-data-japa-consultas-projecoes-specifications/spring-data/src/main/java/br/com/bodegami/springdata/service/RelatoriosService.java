package br.com.bodegami.springdata.service;

import br.com.bodegami.springdata.orm.Funcionario;
import br.com.bodegami.springdata.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private boolean system = true;
    private final FuncionarioRepository repository;

    public RelatoriosService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual acao de RELATORIOS deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
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


}
