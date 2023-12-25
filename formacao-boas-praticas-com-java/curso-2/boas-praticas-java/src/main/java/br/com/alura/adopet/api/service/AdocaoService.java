package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AprovacaoAdocaoRequest;
import br.com.alura.adopet.api.dto.ReprovacaoAdocaoRequest;
import br.com.alura.adopet.api.dto.SolicitacaoAdocaoRequest;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoSolicitacaoAdocao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private List<ValidacaoSolicitacaoAdocao> validacoes;

    public void solicitar(SolicitacaoAdocaoRequest dto) {

        Pet pet = petRepository.getReferenceById(dto.idPet());
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

        //chamar as validacoes (Patterns Strategy & Chain of Responsability)
        validacoes.forEach(validacao -> validacao.validar(dto));

        Adocao adocao = new Adocao(tutor, pet, dto.motivo());

        adocaoRepository.save(adocao);

//        emailService.enviarEmail(adocao.getPet().getAbrigo().getEmail(),
//                "Solicitação de adoção",
//                "Olá " +adocao.getPet().getAbrigo().getNome() +
//                        "!\n\nUma solicitação de adoção foi registrada hoje para o pet: " +adocao.getPet().getNome() +
//                        ". \nFavor avaliar para aprovação ou reprovação.");
    }

    @Transactional
    public void aprovar(AprovacaoAdocaoRequest dto) {

        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());

        adocao.marcarComoAprovado();
        adocao.getPet().setAdotado(true);

        adocaoRepository.save(adocao);

        //Como estamos carregando um entidade do database, qualquer mudança na entidade será salva no database
        //adocaoRepository.save(adocao);

//        emailService.enviarEmail(adocao.getTutor().getEmail(),
//                "Adoção aprovada",
//                "Parabéns " +adocao.getTutor().getNome() +
//                        "!\n\nSua adoção do pet " +adocao.getPet().getNome() +
//                        ", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
//                        ", foi aprovada.\nFavor entrar em contato com o abrigo " +adocao.getPet().getAbrigo().getNome() +
//                        " para agendar a busca do seu pet.");
    }

    @Transactional
    public void reprovar(ReprovacaoAdocaoRequest dto) {

        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.getPet().setAdotado(false);

        adocao.marcarComoReprovada(dto.justificativa());

        //Como estamos carregando um entidade do database, qualquer mudança na entidade será salva no database
        //adocaoRepository.save(adocao);

//        emailService.enviarEmail(adocao.getTutor().getEmail(),
//                "Adoção reprovada",
//                "Olá " +adocao.getTutor().getNome() +
//                        "!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +
//                        ", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
//                        ", foi reprovada pelo abrigo " +adocao.getPet().getAbrigo().getNome() +
//                        " com a seguinte justificativa: " +adocao.getJustificativaStatus());
    }

}
