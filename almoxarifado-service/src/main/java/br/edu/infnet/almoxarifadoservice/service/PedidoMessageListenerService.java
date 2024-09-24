package br.edu.infnet.almoxarifadoservice.service;

import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PedidoMessageListenerService {

    @ServiceActivator(inputChannel = "pedidoInputMessageChannel")
    public void messageReceiver(
            Pedido payload,
            @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE)
            ConvertedBasicAcknowledgeablePubsubMessage<Pedido> message) {

        log.info("***** Mensagem Recebida ---> " + payload);
        message.ack();

//        Chamar serviço responsável pela separação do produto em estoque.
    }
}
