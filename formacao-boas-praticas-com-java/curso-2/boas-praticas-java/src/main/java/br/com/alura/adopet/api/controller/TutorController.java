package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.TutorRequest;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid TutorRequest dto) {
        tutorService.cadastrar(dto);
        return ResponseEntity.ok().body("Cadastrado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@RequestBody @Valid TutorRequest dto) {
        tutorService.atualizar(dto);
        return ResponseEntity.ok().body("Atualizado com sucesso");
    }

}
