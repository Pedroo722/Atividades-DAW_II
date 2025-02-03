package br.edu.ifpb.es.daw.entities.singleTable;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Grande")
public class ProjetoGrande extends Projeto {
    private BigDecimal orcamento;

    public BigDecimal getOrcamento() { return orcamento; }
    public void setOrcamento(BigDecimal orcamento) { this.orcamento = orcamento; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orcamento);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        ProjetoGrande that = (ProjetoGrande) obj;
        return Objects.equals(orcamento, that.orcamento);
    }

    @Override
    public String toString() {
        return super.toString() + " ProjetoGrande{" +
                "orcamento=" + orcamento +
                '}';
    }
}
