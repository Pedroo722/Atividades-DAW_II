package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Carro extends VeiculoDePassageiro {
    private Integer numeroDePortas;

    public Integer getNumeroDePortas() { return numeroDePortas; }
    public void setNumeroDePortas(Integer numeroDePortas) { this.numeroDePortas = numeroDePortas; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroDePortas);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Carro that = (Carro) obj;
        return Objects.equals(numeroDePortas, that.numeroDePortas);
    }

    @Override
    public String toString() {
        return "Carro{" + super.toString() + ", numeroDePortas=" + numeroDePortas + "}";
    }
}
