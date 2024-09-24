package br.edu.infnet.almoxarifadoservice.commands;

import br.edu.infnet.almoxarifadoservice.domain.TipoMovimentacao;
import lombok.Getter;

@Getter
public class AtualizarEstoqueCommand extends BaseCommand<String> {

    public final int quantidade;
    public final TipoMovimentacao tipoMovimentacao;

    public AtualizarEstoqueCommand(String id, int quantidade, TipoMovimentacao tipoMovimentacao) {
        super(id);
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
