package br.com.alura.escola.infra.aluno;

import org.springframework.security.crypto.bcrypt.BCrypt;

import br.com.alura.escola.dominio.aluno.CifradorDeSenha;

public class CifradorDeSenhaComBCrypt implements CifradorDeSenha {

    @Override
    public String cifrarSenha(String senha) {

        // Gera um sal aleatório
        String salGerado = BCrypt.gensalt();
        //System.out.println("O sal gerado foi $" + salGerado + "$");

        
        // Gera a senha hasheada utilizando o sal gerado
        String senhaHasheada = BCrypt.hashpw(senha, salGerado);

        return senhaHasheada;
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return BCrypt.checkpw(senhaCifrada, senha);
    }

}
