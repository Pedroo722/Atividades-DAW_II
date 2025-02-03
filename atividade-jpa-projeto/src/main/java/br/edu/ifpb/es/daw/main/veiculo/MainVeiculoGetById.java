package br.edu.ifpb.es.daw.main.veiculo;

import br.edu.ifpb.es.daw.entities.joined.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainVeiculoGetById {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            long veiculoId = 1;
            Veiculo veiculo = em.find(Veiculo.class, veiculoId);
            
            if (veiculo != null) {
                System.out.println(veiculo);
            } else {
                System.out.println("Veiculo não encontrado.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao recuperar veiculo pelo ID.");
        }
    }
}