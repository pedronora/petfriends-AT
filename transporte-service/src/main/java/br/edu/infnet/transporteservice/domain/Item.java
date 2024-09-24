package br.edu.infnet.transporteservice.domain;

import br.edu.infnet.transporteservice.domain.valueobjetcs.ValorTotal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String produtoId;
  private int quantidade;
  private BigDecimal precoUnitario;

  public ValorTotal getTotal() {
    return new ValorTotal(precoUnitario.multiply(new BigDecimal(quantidade)));
  }
}
