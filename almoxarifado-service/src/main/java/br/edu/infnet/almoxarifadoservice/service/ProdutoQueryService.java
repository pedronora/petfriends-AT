package br.edu.infnet.almoxarifadoservice.service;

import br.edu.infnet.almoxarifadoservice.domain.Produto;
import br.edu.infnet.almoxarifadoservice.infra.ProdutoRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoQueryService {

    private final EventStore eventStore;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoQueryService(EventStore eventStore, ProdutoRepository produtoRepository) {
        this.eventStore = eventStore;
        this.produtoRepository = produtoRepository;
    }

    public List<Object> listarEventos(String id) {
        return eventStore.readEvents(id, 0).asStream().map(record -> record.getPayload()).collect(Collectors.toList());
    }

    public Produto obterPorId(String id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
