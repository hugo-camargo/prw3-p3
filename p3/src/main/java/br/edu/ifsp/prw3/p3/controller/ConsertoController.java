package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados) {

        repository.save(new Conserto(dados));
    }

    @GetMapping("/dados")
    public ResponseEntity listar(Pageable paginacao) {
        var pagina = repository.findAll(paginacao);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/algunsdados")
    public ResponseEntity listarAlgunsDados() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable long id){

        Optional<Conserto> consertoOptional = repository.findById(id);

        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id){
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
