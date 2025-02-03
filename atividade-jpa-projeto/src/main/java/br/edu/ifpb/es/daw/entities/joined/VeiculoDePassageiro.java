package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class VeiculoDePassageiro extends Veiculo {
    private Integer numeroMaximoPassageiros;

    public Integer getNumeroMaximoPassageiros() { return numeroMaximoPassageiros; }
    public void setNumeroMaximoPassageiros(Integer numeroMaximoPassageiros) { this.numeroMaximoPassageiros = numeroMaximoPassageiros; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroMaximoPassageiros);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        VeiculoDePassageiro that = (VeiculoDePassageiro) obj;
        return Objects.equals(numeroMaximoPassageiros, that.numeroMaximoPassageiros);
    }

    @Override
    public String toString() {
        return "VeiculoDePassageiro{" + super.toString() + ", numeroMaximoPassageiros=" + numeroMaximoPassageiros + "}";
    }
}
