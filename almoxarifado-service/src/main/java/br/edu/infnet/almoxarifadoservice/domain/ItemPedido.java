package br.edu.infnet.almoxarifadoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
  private String produtoId;
  private int quantidade;
}
