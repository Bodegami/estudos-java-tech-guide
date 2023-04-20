package br.com.bodegami.springdata;

import br.com.bodegami.springdata.orm.Cargo;
import br.com.bodegami.springdata.repository.CargoRepository;
import br.com.bodegami.springdata.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (system) {

			System.out.println("Qual acao voce deseja executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");


			int action = sc.nextInt();
			if (action == 1) {
				cargoService.inicial(sc);
			} else {
				system = false;
			}

		}

//
//
//		Cargo cargo = new Cargo();
//		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
//		repository.save(cargo);
	}
}
