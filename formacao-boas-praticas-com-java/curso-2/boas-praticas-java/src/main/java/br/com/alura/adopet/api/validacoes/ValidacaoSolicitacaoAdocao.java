package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoRequest;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoRequest dto);

}
