package br.edu.ifpb.es.daw.entities;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "CORRIDA",
    uniqueConstraints = @UniqueConstraint(name = "uc_corrida__nome_e_dataRealizacao", columnNames = {"nome", "data_realizacao"}),
    indexes = @Index(name = "ix_corrida__nome_e_dataRealizacao", columnList = "nome, data_realizacao")
)
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(
        name = "GRIDS_LARGADA",
        joinColumns = @JoinColumn(name = "corrida_id")
    )
    @MapKeyColumn(name = "POSICAO")
    @Column(name = "NOME_PILOTO")
    private Map<Integer, String> gridLargada;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_realizacao", nullable = false)
    private Date dataRealizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCorrida status;

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Map<Integer, String> getGridLargada() { return gridLargada; }
    public Date getDataRealizacao() { return dataRealizacao; }
    public StatusCorrida getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setGridLargada(Map<Integer, String> gridLargada) { this.gridLargada = gridLargada; }
    public void setDataRealizacao(Date dataRealizacao) { this.dataRealizacao = dataRealizacao; }
    public void setStatus(StatusCorrida status) { this.status = status; }

    // hashCode baseado em nome and dataRealizacao
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Corrida)) return false;
        Corrida corrida = (Corrida) obj;
        return Objects.equals(nome, corrida.nome) && Objects.equals(dataRealizacao, corrida.dataRealizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataRealizacao);
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                ", status=" + status +
                '}';
    }
}
