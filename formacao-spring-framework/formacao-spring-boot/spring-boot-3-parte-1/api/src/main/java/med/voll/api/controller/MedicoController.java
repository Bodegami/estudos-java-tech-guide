package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        Medico medico = repository.save(new Medico(dados));
        return ResponseEntity.ok(medico);
    }

    @GetMapping
    @Transactional
    //O pageable é opcional na requisicao, se for enviado na request o Spring utilizara, caso contrario é usado o default
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    //Como o metodo é anotado com a @Transactional, a Jpa abre uma transacao ee a partir disso carregamos uma
    //entidade do banco. Qualquer alteração feita nessa entidade, será comitada no banco quando o metodo encerrar
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
    }
}
