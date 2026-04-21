package br.edu.ifsp.prw3.p3.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "^\\d{4}$", message = "O ano deve ter exatamente 4 dígitos")
        String ano) {}
