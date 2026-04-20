package br.edu.ifsp.prw3.p3.conserto;

import br.edu.ifsp.prw3.p3.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.p3.mecanico.Mecanico;
import br.edu.ifsp.prw3.p3.veiculo.DadosVeiculo;
import br.edu.ifsp.prw3.p3.veiculo.Veiculo;

public record DadosConserto(String dataEntrada, String dataSaida, DadosMecanico mecanicoResponsavel, DadosVeiculo veiculo) {}
