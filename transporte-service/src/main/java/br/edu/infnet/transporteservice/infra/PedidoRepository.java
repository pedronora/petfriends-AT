package br.edu.infnet.transporteservice.infra;

import br.edu.infnet.transporteservice.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
