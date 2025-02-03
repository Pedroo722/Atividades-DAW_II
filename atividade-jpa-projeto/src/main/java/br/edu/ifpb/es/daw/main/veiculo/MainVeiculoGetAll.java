package br.edu.ifpb.es.daw.main.veiculo;

import java.util.List;

import br.edu.ifpb.es.daw.entities.joined.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainVeiculoGetAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            List<Veiculo> veiculoss = em.createQuery("SELECT e FROM Veiculo e", Veiculo.class).getResultList();
            veiculoss.forEach(System.out::println);
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao recuperar veiculos.");
        }
    }
}