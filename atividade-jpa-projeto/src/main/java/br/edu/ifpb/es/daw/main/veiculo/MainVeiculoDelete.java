package br.edu.ifpb.es.daw.main.veiculo;

import br.edu.ifpb.es.daw.entities.joined.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainVeiculoDelete {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            long veiculoId = 1;
            
            em.getTransaction().begin();
            var veiculo = em.find(Veiculo.class, veiculoId);
            if (veiculo != null) {
                em.remove(veiculo);
            }
            em.getTransaction().commit();
            System.out.println("Veiculo apagado.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar veiculo.");
        }
    }
}
