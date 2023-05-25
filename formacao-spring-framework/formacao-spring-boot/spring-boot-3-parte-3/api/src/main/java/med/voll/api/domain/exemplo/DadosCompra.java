package med.voll.api.domain.exemplo;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

/**
 *
 * A anotação @JsonAlias serve para mapear “apelidos” alternativos para os campos
 * que serão recebidos do JSON, sendo possível atribuir múltiplos alias
 * 
 */

public record DadosCompra(
        @JsonAlias({"produto_id", "id_produto"}) Long idProduto,
        @JsonAlias({"data_da_compra", "data_compra"}) LocalDate dataCompra
){}
