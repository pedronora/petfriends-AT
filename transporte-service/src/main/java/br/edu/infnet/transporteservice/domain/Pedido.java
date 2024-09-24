package br.edu.infnet.transporteservice.domain;

import br.edu.infnet.transporteservice.domain.valueobjetcs.ValorTotal;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
@Entity
public class Pedido {
  @AggregateIdentifier @Id private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Transportadora transportadora;
  private Long clientId;
  private String enderecoEntrega;
  @OneToMany private List<Item> itens;
  @Embedded private ValorTotal valorTotal;
  private Status status;
}
