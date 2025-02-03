package br.edu.ifpb.es.daw.entities.joined;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class VeiculoDeTransporte extends Veiculo {
    private Integer cargaMaximaKg;

    public Integer getCargaMaximaKg() { return cargaMaximaKg; }
    public void setCargaMaximaKg(Integer cargaMaximaKg) { this.cargaMaximaKg = cargaMaximaKg; }

    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargaMaximaKg);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        VeiculoDeTransporte that = (VeiculoDeTransporte) obj;
        return Objects.equals(cargaMaximaKg, that.cargaMaximaKg);
    }

    @Override
    public String toString() {
        return "VeiculoDeTransporte{" + super.toString() + ", cargaMaximaKg=" + cargaMaximaKg + "}";
    }
}
