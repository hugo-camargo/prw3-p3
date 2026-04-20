package br.edu.ifsp.prw3.p3.conserto;

import br.edu.ifsp.prw3.p3.mecanico.Mecanico;
import br.edu.ifsp.prw3.p3.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "Conserto")
@Table(name = "consertos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data_entrada")
    private String dataEntrada;

    @Column(name = "data_saida")
    private String dataSaida;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nome", column = @Column(name = "mecanico_nome")),
            @AttributeOverride(name = "anosExperiencia", column = @Column(name = "mecanico_anos_experiencia"))
    })
    private Mecanico mecanicoResponsavel;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "marca", column = @Column(name = "veiculo_marca")),
            @AttributeOverride(name = "modelo", column = @Column(name = "veiculo_modelo")),
            @AttributeOverride(name = "ano", column = @Column(name = "veiculo_ano"))
    })
    private Veiculo veiculo;

    public Conserto(DadosConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanicoResponsavel = new Mecanico(dados.mecanicoResponsavel());
        this.veiculo = new Veiculo(dados.veiculo());
    }
}
