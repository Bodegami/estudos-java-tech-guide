package med.voll.api.domain.medico;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    //Por padrao, ao criar uma classe de test da camada de persistencia, o Spring considera que ele não deve
    //usar o banco de dados da aplicação. Ele espera a conexao com um banco de dados em memoria.
    //Podemos indicar para Spring utilizar o mesmo banco de dados da aplicação nos testes com a anotação
    //@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

    @Test
    void escolherMedicoAleatorioLivreNaData() {



    }
}