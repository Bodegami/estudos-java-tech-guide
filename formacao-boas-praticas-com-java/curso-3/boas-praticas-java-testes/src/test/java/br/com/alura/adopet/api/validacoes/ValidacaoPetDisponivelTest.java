package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoPetDisponivelTest {

    @DisplayName("")
    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {
        //ARRANGE
        SolicitacaoAdocaoDto dto = new SolicitacaoAdocaoDto(
                7l,
                2l,
                "Motivo qualquer"
        );

        ValidacaoPetDisponivel validacao = new ValidacaoPetDisponivel();


        //ASSERT + ACT
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

}