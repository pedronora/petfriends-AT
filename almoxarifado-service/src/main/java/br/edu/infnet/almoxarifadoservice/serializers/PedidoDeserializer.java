package br.edu.infnet.almoxarifadoservice.serializers;

import br.edu.infnet.almoxarifadoservice.domain.ItemPedido;
import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDeserializer extends StdDeserializer<Pedido> {
  public PedidoDeserializer() {
    super(Pedido.class);
  }

  @Override
  public Pedido deserialize(JsonParser jsonParser, DeserializationContext context)
      throws IOException {
    ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
    JsonNode node = mapper.readTree(jsonParser);

    String pedidoId = node.get("pedidoId").asText();
    List<ItemPedido> itens = new ArrayList<>();

    for (JsonNode itemNode : node.get("itens")) {
      String produtoId = itemNode.get("produtoId").asText();
      int quantidade = itemNode.get("quantidade").asInt();
      itens.add(new ItemPedido(produtoId, quantidade));
    }

    return new Pedido(pedidoId, itens);
  }
}
