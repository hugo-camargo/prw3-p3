package br.edu.ifsp.prw3.p3.conserto;

public record DadosDetalhamentoConserto(Long id, String dataEntrada, String dataSaida,
                                        String nome, Integer anosExperiencia, String marca,
                                        String modelo, String ano, String cor, Boolean ativo) {

    public DadosDetalhamentoConserto(Conserto conserto){
        this(conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getMecanicoResponsavel().getAnosExperiencia(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getAno(),
                conserto.getVeiculo().getCor(),
                conserto.getAtivo()
        );
    }
}
