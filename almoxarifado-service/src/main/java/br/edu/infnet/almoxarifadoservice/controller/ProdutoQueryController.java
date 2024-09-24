package br.edu.infnet.almoxarifadoservice.controller;

import br.edu.infnet.almoxarifadoservice.domain.Produto;
import br.edu.infnet.almoxarifadoservice.service.ProdutoQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoQueryController {

    private final ProdutoQueryService service;

    public ProdutoQueryController(ProdutoQueryService service) {
        this.service = service;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id) {
        return service.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable(value = "id") String id) {
        return service.obterPorId(id);
    }
}