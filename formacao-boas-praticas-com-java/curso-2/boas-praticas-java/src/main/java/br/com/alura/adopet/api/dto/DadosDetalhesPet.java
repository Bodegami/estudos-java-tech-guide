package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;

public record DadosDetalhesPet(Long id,
                               String tipo,
                               String nome,
                               String raca,
                               Integer idade,
                               String cor,
                               Float peso,
                               Boolean adotado,
                               Long idAbrigo,
                               Long idAdocao) {

    public DadosDetalhesPet(Pet pet) {
        this(
                pet.getId(),
                pet.getTipo().name(),
                pet.getNome(),
                pet.getRaca(),
                pet.getIdade(),
                pet.getCor(),
                pet.getPeso(),
                pet.getAdotado(),
                pet.getAbrigo().getId(),
                pet.getAdocao().getId()
        );
    }

}
