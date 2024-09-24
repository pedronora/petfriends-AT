package br.edu.infnet.almoxarifadoservice.events;

import br.edu.infnet.almoxarifadoservice.domain.TipoMovimentacao;
import lombok.Getter;

@Getter
public class EstoqueAtualizadoEvent extends BaseEvent<String> {

    private final int quantidade;
    private final TipoMovimentacao tipoMovimentacao;

    public EstoqueAtualizadoEvent(String id, int quantidade, TipoMovimentacao tipoMovimentacao) {
        super(id);
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
