package br.edu.ifsp.prw3.p3.conserto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,

        String dataSaida,

        String nome,

        int anosExperiencia

) {
        public DadosAtualizacaoConserto(Conserto conserto) {
                this(
                        conserto.getId(),
                        conserto.getDataSaida(),
                        conserto.getMecanicoResponsavel().getNome(),
                        conserto.getMecanicoResponsavel().getAnosExperiencia()
                );
        }
}
