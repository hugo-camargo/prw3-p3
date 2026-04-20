package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.conserto.DadosConserto;
import br.edu.ifsp.prw3.p3.conserto.Conserto;
import br.edu.ifsp.prw3.p3.conserto.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados) {
        repository.save(new Conserto(dados));
    }
}
