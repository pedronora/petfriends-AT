package br.edu.infnet.almoxarifadoservice.service;

import br.edu.infnet.almoxarifadoservice.commands.AtualizarEstoqueCommand;
import br.edu.infnet.almoxarifadoservice.commands.CriarProdutoCommand;
import br.edu.infnet.almoxarifadoservice.domain.Produto;
import br.edu.infnet.almoxarifadoservice.domain.TipoMovimentacao;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProdutoCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public ProdutoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarProduto(Produto produto) {
        return commandGateway.send(new CriarProdutoCommand(
                UUID.randomUUID().toString(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEmEstoque()));
    }

    public CompletableFuture<String> atualizarEstoque(String id, int quantidade, TipoMovimentacao tipoMovimentacao) {
        return commandGateway.send(new AtualizarEstoqueCommand(id, quantidade, tipoMovimentacao));
    }
}
