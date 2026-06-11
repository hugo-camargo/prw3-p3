package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.conserto.*;
import br.edu.ifsp.prw3.p3.services.ConsertoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    private final ConsertoService service;

    public ConsertoController(ConsertoService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados,
                                    UriComponentsBuilder uriBuilder) {

        Conserto conserto = service.criar(dados);

        var uri = uriBuilder.path("/consertos/{id}")
                .buildAndExpand(conserto.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new DadosConserto(conserto));
    }

    @GetMapping("/algunsdados")
    public ResponseEntity listarAtivos() {
        var lista = service.listarAtivos()
                .stream()
                .map(DadosListagemConserto::new)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {

        return service.buscarPorId(id)
                .map(conserto -> ResponseEntity.ok(new DadosDetalhamentoConserto(conserto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {

        Conserto conserto = service.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}