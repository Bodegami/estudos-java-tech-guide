package br.com.bodegami.springdata.service;

import br.com.bodegami.springdata.orm.Cargo;
import br.com.bodegami.springdata.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descricao do cargo:");

        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Salvo!");
    }

}
