package br.edu.infnet.almoxarifadoservice.commands;

import java.time.LocalDateTime;

public class CriarProdutoCommand extends BaseCommand<String>{

    public final String nome;
    public final String descricao;
    public final double preco;
    public int quantidadeEmEstoque;
    public LocalDateTime timestamp;

    public CriarProdutoCommand(String id, String nome, String descricao, double preco, int quantidadeInicial) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeInicial;
        this.timestamp = LocalDateTime.now();
    }
}
