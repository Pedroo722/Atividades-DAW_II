package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Bicicleta extends VeiculoDePassageiro {
    private Integer alturaDoSelimEmCm;

    public Integer getAlturaDoSelimEmCm() { return alturaDoSelimEmCm; }
    public void setAlturaDoSelimEmCm(Integer alturaDoSelimEmCm) { this.alturaDoSelimEmCm = alturaDoSelimEmCm; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alturaDoSelimEmCm);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Bicicleta that = (Bicicleta) obj;
        return Objects.equals(alturaDoSelimEmCm, that.alturaDoSelimEmCm);
    }

    @Override
    public String toString() {
        return "Bicicleta{" + super.toString() + ", alturaDoSelimEmCm=" + alturaDoSelimEmCm + "}";
    }
}
