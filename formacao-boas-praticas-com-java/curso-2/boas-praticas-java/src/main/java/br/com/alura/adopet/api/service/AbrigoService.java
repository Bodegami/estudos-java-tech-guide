package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoRequest;
import br.com.alura.adopet.api.dto.DetalhesAbrigoResponse;
import br.com.alura.adopet.api.dto.DetalhesPetResponse;
import br.com.alura.adopet.api.dto.PetRequest;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public List<DetalhesAbrigoResponse> listarAbrigos() {
        return abrigoRepository.findAll().stream().map(DetalhesAbrigoResponse::new).toList();
    }

    public List<DetalhesPetResponse> listarPets(String idOuNome) {
        boolean isTypeNumber = idOuNome.matches("\\d"); //retorna true se conter um tipo numerico
        try {
            if(isTypeNumber) {
                return abrigoRepository.getReferenceById(Long.parseLong(idOuNome))
                        .getPets()
                        .stream()
                        .map(DetalhesPetResponse::new)
                        .toList();
            } else {
                return abrigoRepository.findByNome(idOuNome)
                        .getPets()
                        .stream()
                        .map(DetalhesPetResponse::new)
                        .toList();
            }
        } catch (EntityNotFoundException e) {
            throw new ValidacaoException("Abrigo não encontrado...");
        }
    }

    @Transactional
    public void cadastrar(AbrigoRequest dto) {
        boolean isAlreadyExists = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (isAlreadyExists) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }

        abrigoRepository.save(new Abrigo(dto));
    }

    @Transactional
    public void cadastrarPet(String idOuNome, PetRequest dto) {
        boolean isTypeNumber = idOuNome.matches("\\d"); //retorna true se conter um tipo numerico
        try {
            Abrigo abrigo;

            if (isTypeNumber) {
                abrigo = abrigoRepository.getReferenceById(Long.parseLong(idOuNome));
            } else {
                abrigo = abrigoRepository.findByNome(idOuNome);
            }

            Pet pet = new Pet(dto);
            pet.setAbrigo(abrigo);
            pet.setAdotado(false);
            abrigo.cadastrarPet(pet);
            abrigoRepository.save(abrigo);

        } catch (EntityNotFoundException e) {
            throw new ValidacaoException("Abrigo não encontrado...");
        }
    }
}
