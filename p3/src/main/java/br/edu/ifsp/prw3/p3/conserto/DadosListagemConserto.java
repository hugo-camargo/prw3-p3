package br.edu.ifsp.prw3.p3.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosListagemConserto(Long id, String dataEntrada, String dataSaida,
                                    String nome, Integer anosExperiencia, String marca, String modelo) {

    public DadosListagemConserto(Conserto conserto){
        this(conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getMecanicoResponsavel().getAnosExperiencia(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
