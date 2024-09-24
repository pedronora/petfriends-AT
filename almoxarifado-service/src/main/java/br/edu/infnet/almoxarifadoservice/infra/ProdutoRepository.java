package br.edu.infnet.almoxarifadoservice.infra;

import br.edu.infnet.almoxarifadoservice.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {}
