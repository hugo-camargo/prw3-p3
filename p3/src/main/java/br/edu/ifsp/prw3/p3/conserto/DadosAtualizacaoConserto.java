package br.edu.ifsp.prw3.p3.conserto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,

        String dataSaida,

        String nome,

        int anosExperiencia

) { }
