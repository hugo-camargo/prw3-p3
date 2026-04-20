package br.edu.ifsp.prw3.p3.veiculo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Embeddable
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo() { }

    public Veiculo(DadosVeiculo dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}
