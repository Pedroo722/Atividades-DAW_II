package br.edu.ifpb.es.daw.main.veiculo;

import br.edu.ifpb.es.daw.entities.joined.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainVeiculoSave {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setNome("Veiculo A");
            veiculo.setConstrutora("Ford");
            
            em.getTransaction().begin();
            em.persist(veiculo);
            em.getTransaction().commit();
            System.out.println("Veiculo salvo.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao salver veiculo.");
        }
    }
}
