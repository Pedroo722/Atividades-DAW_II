package br.edu.ifpb.es.daw.entities.tablePerClass;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class EmpregadoTempoParcial extends Empregado {
    private BigDecimal valorHora;

    public BigDecimal getValorHora() { return valorHora; }
    public void setValorHora(BigDecimal valorHora) { this.valorHora = valorHora; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), valorHora);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        EmpregadoTempoParcial that = (EmpregadoTempoParcial) obj;
        return Objects.equals(valorHora, that.valorHora);
    }


    @Override
    public String toString() {
        return "EmpregadoTempoParcial{" + super.toString() + ", valorHora=" + valorHora + "}";
    }
}
