package br.edu.infnet.transporteservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        new PubSubInboundChannelAdapter(pubSubTemplate, "transportar-pedido-sub");
    adapter.setOutputChannel(messageChannel);
    adapter.setAckMode(AckMode.MANUAL);
    adapter.setPayloadType(String.class);
    return adapter;
  }
}
