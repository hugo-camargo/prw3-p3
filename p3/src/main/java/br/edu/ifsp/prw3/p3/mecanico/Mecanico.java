package br.edu.ifsp.prw3.p3.mecanico;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Embeddable
@Getter
public class Mecanico {
    private String nome;
    private int anosExperiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosExperiencia = dados.anosExperiencia();
    }

    public Mecanico() {}

    public void atualizarInformacao(DadosMecanico dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.anosExperiencia() > 0){
            this.anosExperiencia = dados.anosExperiencia();
        }
    }
}
