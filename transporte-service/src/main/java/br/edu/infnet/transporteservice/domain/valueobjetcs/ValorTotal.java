package br.edu.infnet.transporteservice.domain.valueobjetcs;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ValorTotal {

  BigDecimal valor;

  public ValorTotal sum(BigDecimal novoValor) {
    if (novoValor == null || novoValor.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("O valor adicionado não pode ser nulo ou negativo");
    }
    return new ValorTotal(this.valor.add(novoValor));
  }

  public ValorTotal subtract(BigDecimal valorSubtraido) {
    if (valorSubtraido == null || valorSubtraido.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("O valor subtraído não pode ser nulo ou negativo");
    }

    if (valorSubtraido.compareTo(this.valor) > 0) {
      throw new IllegalArgumentException("O valor total não pode ser menor que zero");
    }

    BigDecimal resultado = this.valor.subtract(valorSubtraido);

    return new ValorTotal(resultado);
  }
}
