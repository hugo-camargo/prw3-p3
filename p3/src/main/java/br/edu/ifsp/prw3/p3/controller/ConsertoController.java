package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.conserto.DadosConserto;
import br.edu.ifsp.prw3.p3.conserto.Conserto;
import br.edu.ifsp.prw3.p3.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.p3.conserto.DadosListagemConserto;
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
    public ResponseEntity<Conserto> getConsertoById(@PathVariable long id){

        Optional<Conserto> consertoOptional = repository.findById(id);

        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(conserto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();
    }
}
