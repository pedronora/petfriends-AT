package br.edu.infnet.almoxarifadoservice.events;

import lombok.Getter;


@Getter
public class ProdutoCriadoEvent extends BaseEvent<String> {

    private final String nome;
    private final String descricao;
    private final double preco;
    private final int quantidadeEmEstoque;

    public ProdutoCriadoEvent(String id, String nome, String descricao, double preco, int quantidadeEmEstoque) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
