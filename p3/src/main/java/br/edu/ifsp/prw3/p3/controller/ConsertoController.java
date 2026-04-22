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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable long id){
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();
    }
}
