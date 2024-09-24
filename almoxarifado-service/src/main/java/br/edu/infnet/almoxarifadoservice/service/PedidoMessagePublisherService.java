package br.edu.infnet.almoxarifadoservice.service;

import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoMessagePublisherService {

  private final PubSubTemplate pubSubTemplate;

  @Qualifier("pedidoMessageConverter")
  private final JacksonPubSubMessageConverter converter;

  public void publishPedido(Pedido pedido) {
    pubSubTemplate.setMessageConverter(converter);
    pubSubTemplate.publish("separar-pedido", pedido);
    log.info("****** Mensagem publicada ----> " + pedido);
  }
}
