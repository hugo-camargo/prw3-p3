package br.edu.ifsp.prw3.p3.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosMecanico(

        @NotBlank
        String nome,

        @NotNull
        int anosExperiencia) { }
