package br.com.alura.adopet.api.dto;

import java.util.List;

public record AbrigoRequest(

        String nome,
        String telefone,
        String email,
        List<PetRequest> pets
) {

}
