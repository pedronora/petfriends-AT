package br.edu.infnet.almoxarifadoservice.config;

import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import br.edu.infnet.almoxarifadoservice.serializers.PedidoDeserializer;
import br.edu.infnet.almoxarifadoservice.serializers.PedidoSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PedidoPubSubConfig {

  @Bean(name = "pedidoMessageConverter")
  public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(Pedido.class, new PedidoSerializer());
    simpleModule.addDeserializer(Pedido.class, new PedidoDeserializer());
    objectMapper.registerModule(simpleModule);
    return new JacksonPubSubMessageConverter(objectMapper);
  }

  @Bean(name = "pedidoInputMessageChannel")
  public MessageChannel inputMessageChannel() {
    return new PublishSubscribeChannel();
  }

  @Bean(name = "pedidoInboundChannelAdapter")
  public PubSubInboundChannelAdapter inboundChannelAdapter(
      @Qualifier("pedidoInputMessageChannel") MessageChannel messageChannel,
      PubSubTemplate pubSubTemplate) {

    pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter());
    PubSubInboundChannelAdapter adapter =
        new PubSubInboundChannelAdapter(pubSubTemplate, "separar-pedido-sub");
    adapter.setOutputChannel(messageChannel);
    adapter.setAckMode(AckMode.MANUAL);
    adapter.setPayloadType(Pedido.class);
    return adapter;
  }
}
