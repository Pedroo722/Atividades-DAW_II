package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String construtora;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getConstrutora() { return construtora; }
    public void setConstrutora(String construtora) { this.construtora = construtora; }

    @Override
    public int hashCode() { return Objects.hash(id, nome, construtora); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return Objects.equals(id, veiculo.id);
    }

    @Override
    public String toString() {
        return "Veiculo{id=" + id + ", nome='" + nome + "', construtora='" + construtora + "'}";
    }
}
