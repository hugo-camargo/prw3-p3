package br.edu.ifsp.prw3.p3.conserto;

import br.edu.ifsp.prw3.p3.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.p3.mecanico.Mecanico;
import br.edu.ifsp.prw3.p3.veiculo.DadosVeiculo;
import br.edu.ifsp.prw3.p3.veiculo.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(

        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String dataEntrada,


        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String dataSaida,

        @NotBlank
        @Valid
        DadosMecanico mecanicoResponsavel,

        @NotBlank
        @Valid
        DadosVeiculo veiculo) {}
