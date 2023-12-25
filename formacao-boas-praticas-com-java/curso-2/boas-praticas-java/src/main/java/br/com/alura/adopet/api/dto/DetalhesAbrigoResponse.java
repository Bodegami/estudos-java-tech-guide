package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;

import java.util.List;

public record DetalhesAbrigoResponse(
        Long id,
        String nome,
        String telefone,
        String email,
        List<DetalhesPetResponse> pets) {

    public DetalhesAbrigoResponse(Abrigo abrigo) {
        this(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getTelefone(),
                abrigo.getEmail(),
                abrigo.getPets()
                        .stream()
                        .map(DetalhesPetResponse::new)
                        .toList()
        );
    }

}
