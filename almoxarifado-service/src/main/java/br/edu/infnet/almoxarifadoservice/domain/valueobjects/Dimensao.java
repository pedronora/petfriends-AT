package br.edu.infnet.almoxarifadoservice.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Dimensao {
  private double altura;
  private double largura;
  private double profundidade;

  public Dimensao(double altura, double largura, double profundidade) {
    if (altura <= 0 || largura <= 0 || profundidade <= 0) {
      throw new IllegalArgumentException(
          "Altura, largura e profundidade não podem ser menores ou iguais a zero.");
    }
    this.altura = altura;
    this.largura = largura;
    this.profundidade = profundidade;
  }
}
