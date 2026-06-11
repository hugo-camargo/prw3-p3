package br.edu.ifsp.prw3.p3.services;

import br.edu.ifsp.prw3.p3.conserto.Conserto;
import br.edu.ifsp.prw3.p3.conserto.ConsertoRepository;
import br.edu.ifsp.prw3.p3.conserto.DadosAtualizacaoConserto;
import br.edu.ifsp.prw3.p3.conserto.DadosConserto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsertoService {
    private final ConsertoRepository consertoRepository;

    public ConsertoService(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    public Conserto criar(DadosConserto dados) {
        Conserto conserto = new Conserto(dados);
        return consertoRepository.save(conserto);
    }

    public List<Conserto> listarAtivos() {
        return consertoRepository.findAllByAtivoTrue();
    }

    public Optional<Conserto> buscarPorId(Long id) {
        return consertoRepository.findById(id);
    }

    public Conserto atualizar(DadosAtualizacaoConserto dados) {
        Conserto conserto = consertoRepository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);
        return conserto;
    }

    public void excluir(Long id) {
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.excluir();
    }
}
