package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.AbrigoRequest;
import br.com.alura.adopet.api.dto.DetalhesAbrigoResponse;
import br.com.alura.adopet.api.dto.DetalhesPetResponse;
import br.com.alura.adopet.api.dto.PetRequest;
import br.com.alura.adopet.api.service.AbrigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<List<DetalhesAbrigoResponse>> listar() {
        return ResponseEntity.ok(abrigoService.listarAbrigos());
    }

    @PostMapping

    public ResponseEntity<String> cadastrar(@RequestBody @Valid AbrigoRequest dto) {
        abrigoService.cadastrar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<DetalhesPetResponse>> listarPets(@PathVariable String idOuNome) {
        return ResponseEntity.ok(abrigoService.listarPets(idOuNome));
    }

    @PostMapping("/{idOuNome}/pets")
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid PetRequest dto) {
        abrigoService.cadastrarPet(idOuNome, dto);
        return ResponseEntity.ok("Pet cadastrado com sucesso!");
    }

}
