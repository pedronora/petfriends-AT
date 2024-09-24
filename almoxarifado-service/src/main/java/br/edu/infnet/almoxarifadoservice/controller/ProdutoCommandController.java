package br.edu.infnet.almoxarifadoservice.controller;

import br.edu.infnet.almoxarifadoservice.domain.Produto;
import br.edu.infnet.almoxarifadoservice.domain.TipoMovimentacao;
import br.edu.infnet.almoxarifadoservice.service.ProdutoCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoCommandController {

    private final ProdutoCommandService produtoCommandService;

    @PostMapping("/criar")
    public CompletableFuture<String> criarProduto(@RequestBody Produto produto) {
        return produtoCommandService.criarProduto(produto);
    }

    @PostMapping("/{id}/entrada")
    public CompletableFuture<String> EntradaEstoque(
            @PathVariable String id,
            @RequestBody Map<String, Object> body) {
        int quantidade = (Integer) body.get("quantidade");
        return produtoCommandService.atualizarEstoque(id, quantidade, TipoMovimentacao.ENTRADA);
    }

    @PostMapping("/{id}/saida")
    public CompletableFuture<String> SaidaEstoque(
            @PathVariable String id,
            @RequestBody Map<String, Object> body) {
        int quantidade = (Integer) body.get("quantidade");
        return produtoCommandService.atualizarEstoque(id, quantidade, TipoMovimentacao.SAIDA);
    }
}
