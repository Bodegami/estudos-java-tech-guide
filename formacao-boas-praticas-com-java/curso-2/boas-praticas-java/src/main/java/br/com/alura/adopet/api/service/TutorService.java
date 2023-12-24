package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.TutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Transactional
    public void cadastrar(TutorDto dto) {
        boolean isAlreadyExists = tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (isAlreadyExists) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }

        tutorRepository.save(new Tutor(dto));
    }

    @Transactional
    public void atualizar(TutorDto dto) {
        boolean isAlreadyExists = tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (isAlreadyExists) {
            tutorRepository.save(new Tutor(dto));
        } else {
            throw new ValidacaoException("Dados do tutor não encontrados...");
        }
    }
}
