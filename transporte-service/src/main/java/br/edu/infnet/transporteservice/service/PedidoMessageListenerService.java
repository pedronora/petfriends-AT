package br.edu.infnet.transporteservice.service;

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
      String pedidoId,
      @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE)
          ConvertedBasicAcknowledgeablePubsubMessage<String> message) {

    log.info("***** Mensagem Recebida ---> pedidoId: " + pedidoId);
    message.ack();
  }
}
