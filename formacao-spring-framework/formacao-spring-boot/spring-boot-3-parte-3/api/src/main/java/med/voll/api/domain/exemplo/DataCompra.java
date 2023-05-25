package med.voll.api.domain.exemplo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 *
 * Essa anotação também pode ser utilizada nas classes DTO que representam
 * as informações que a API devolve, para que assim o JSON devolvido seja
 * formatado de acordo com o pattern configurado. Além disso, ela não se
 * restringe apenas à classe LocalDateTime, podendo também ser utilizada
 * em atributos do tipo LocalDate e LocalTime.
 * 
 */

public record DataCompra(
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data
) {
}
