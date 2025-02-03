package br.edu.ifpb.es.daw.entities.singleTable;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pequeno")
public class ProjetoPequeno extends Projeto {
    private LocalDate prazoMaximoConclusao;

    public LocalDate getPrazoMaximoConclusao() { return prazoMaximoConclusao; }
    public void setPrazoMaximoConclusao(LocalDate prazoMaximoConclusao) { this.prazoMaximoConclusao = prazoMaximoConclusao; }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prazoMaximoConclusao);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        ProjetoPequeno that = (ProjetoPequeno) obj;
        return Objects.equals(prazoMaximoConclusao, that.prazoMaximoConclusao);
    }

    @Override
    public String toString() {
        return super.toString() + " ProjetoPequeno{" +
                "prazoMaximoConclusao=" + prazoMaximoConclusao +
                '}';
    }
}
