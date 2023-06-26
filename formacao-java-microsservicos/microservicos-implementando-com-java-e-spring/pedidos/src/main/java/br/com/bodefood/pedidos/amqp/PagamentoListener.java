package br.com.bodefood.pedidos.amqp;

import br.com.bodefood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentoDto pagamento) {
        String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor: %s
                Status: %s
                """
                .formatted(pagamento.getId(),
                        pagamento.getNumero(),
                        pagamento.getValor(),
                        pagamento.getStatus());

        System.out.println("Recebi a mensagem: " + mensagem);
    }

}
