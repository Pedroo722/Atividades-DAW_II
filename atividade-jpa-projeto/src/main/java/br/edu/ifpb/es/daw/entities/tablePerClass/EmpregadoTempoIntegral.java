package br.edu.ifpb.es.daw.entities.tablePerClass;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class EmpregadoTempoIntegral extends Empregado {
    private BigDecimal salario;

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        EmpregadoTempoIntegral that = (EmpregadoTempoIntegral) obj;
        return Objects.equals(salario, that.salario);
    }

    @Override
    public String toString() {
        return "EmpregadoTempoIntegral{" + super.toString() + ", salario=" + salario + "}";
    }
}
