package br.edu.infnet.almoxarifadoservice;

import br.edu.infnet.almoxarifadoservice.domain.ItemPedido;
import br.edu.infnet.almoxarifadoservice.domain.Pedido;
import br.edu.infnet.almoxarifadoservice.domain.Produto;
import br.edu.infnet.almoxarifadoservice.domain.valueobjects.Dimensao;
import br.edu.infnet.almoxarifadoservice.service.PedidoMessagePublisherService;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlmoxarifadoServiceApplication implements CommandLineRunner {

  @Autowired PedidoMessagePublisherService pedidoPublisherService;

  public static void main(String[] args) {
    SpringApplication.run(AlmoxarifadoServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Dimensao dimensao = new Dimensao(10.5, 20.0, 15.0);

    Produto produto = new Produto();
    produto.setId("550e8400-e29b-41d4-a716-446655440000");
    produto.setNome("Produto Exemplo");
    produto.setDescricao("Descrição do Produto");
    produto.setPreco(29.99);
    produto.setDimensao(dimensao);
    produto.setQuantidadeEmEstoque(100);

    ItemPedido itemPedido = new ItemPedido(produto.getId(), 2);

    Pedido pedido = new Pedido();
    pedido.setPedidoId("pedido-12345");
    pedido.setItens(Collections.singletonList(itemPedido));

    pedidoPublisherService.publishPedido(pedido);
  }
}
