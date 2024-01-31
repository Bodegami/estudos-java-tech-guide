package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoTutorComAdocaoEmAndamento validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Mock
    private Tutor tutor;

    @Mock
    private Pet pet;

    private List<Adocao> adocoes = new ArrayList<>();

    @DisplayName("Nao deve permitir que tutor adote um pet quando o mesmo tem outra adocao em andamento")
    @Test
    void naoDevePermitirAdocaoDePetComTutorComOutraAdocaoEmAndamento() {
        //ARRANGE
        Adocao adocao = new Adocao(tutor, pet, "motivo");
        adocoes.add(adocao);

        BDDMockito.given(adocaoRepository.findAll()).willReturn(adocoes);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);

        //ASSERT + ACT
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

    @DisplayName("Nao deve permitir que tutor adote um pet quando o status da adocao for reprovado")
    @Test
    void naoDevePermitirAdocaoDePetComTutorComStatusAdocaoReprovado() {
        //ARRANGE
        Adocao adocao = new Adocao(tutor, pet, "motivo");
        adocao.marcarComoReprovada("Tutor bloqueado!");
        adocoes.add(adocao);

        BDDMockito.given(adocaoRepository.findAll()).willReturn(adocoes);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);

        //ASSERT + ACT
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

    @DisplayName("Deve permitir que tutor adote um pet quando o status da adocao for aprovado")
    @Test
    void deveriaPermitirAdocaoDePetComTutorSemOutraAdocaoEmAndamento() {
        //ARRANGE
        Tutor novoTutor = new Tutor(new CadastroTutorDto("xpto", "911111111", "tutor@email.com.br"));
        Adocao adocao = new Adocao(novoTutor, pet, "motivo");
        adocao.marcarComoAprovada();
        adocoes.add(adocao);


        BDDMockito.given(adocaoRepository.findAll()).willReturn(adocoes);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(novoTutor);

        //ASSERT + ACT
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

}