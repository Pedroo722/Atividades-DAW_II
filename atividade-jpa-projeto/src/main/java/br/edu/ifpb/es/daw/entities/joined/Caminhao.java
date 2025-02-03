package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Caminhao extends VeiculoDeTransporte {
    private Integer numeroDeVagoes;

    public Integer getNumeroDeVagoes() { return numeroDeVagoes; }
    public void setNumeroDeVagoes(Integer numeroDeVagoes) { this.numeroDeVagoes = numeroDeVagoes; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroDeVagoes);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Caminhao that = (Caminhao) obj;
        return Objects.equals(numeroDeVagoes, that.numeroDeVagoes);
    }

    @Override
    public String toString() {
        return "Caminhao{" + super.toString() + ", numeroDeVagoes=" + numeroDeVagoes + "}";
    }
}
