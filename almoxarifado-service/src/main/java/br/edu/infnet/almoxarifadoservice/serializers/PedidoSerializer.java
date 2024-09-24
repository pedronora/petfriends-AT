package br.edu.infnet.almoxarifadoservice.serializers;

import br.edu.infnet.almoxarifadoservice.domain.ItemPedido;
import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class PedidoSerializer extends StdSerializer<Pedido> {

  public PedidoSerializer() {
    super(Pedido.class);
  }

  @Override
  public void serialize(
      Pedido pedido, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("pedidoId", pedido.getPedidoId());
    jsonGenerator.writeFieldName("itens");
    jsonGenerator.writeStartArray();
    for (ItemPedido item : pedido.getItens()) {
      jsonGenerator.writeStartObject();
      jsonGenerator.writeStringField("produtoId", item.getProdutoId());
      jsonGenerator.writeNumberField("quantidade", item.getQuantidade());
      jsonGenerator.writeEndObject();
    }
    jsonGenerator.writeEndArray();
    jsonGenerator.writeEndObject();
  }
}
