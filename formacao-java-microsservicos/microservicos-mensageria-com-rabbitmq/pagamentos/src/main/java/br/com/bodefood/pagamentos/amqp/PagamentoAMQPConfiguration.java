package br.com.bodefood.pagamentos.amqp;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoAMQPConfiguration {

    //Cria a fila no rabbitmq
    @Bean
    public Queue criaFila() {
        //return new Queue("pagamento.concluido", false);

        return QueueBuilder.nonDurable("pagamento.concluido").build();
    }

    //Cria um RabbitAdmin que permite algumas configuracoes extras
    @Bean
    public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }

    //Inicializa o RabbitAdmin
    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }




}
