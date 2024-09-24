package br.edu.infnet.almoxarifadoservice.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
  private String pedidoId;
  private List<ItemPedido> itens;
}
