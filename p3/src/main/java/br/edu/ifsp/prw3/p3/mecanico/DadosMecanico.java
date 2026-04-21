package br.edu.ifsp.prw3.p3.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(

        @NotBlank
        String nome,

        @NotBlank
        int anosExperiencia) {}
