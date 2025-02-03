package br.edu.ifpb.es.daw.main.projeto;

import br.edu.ifpb.es.daw.entities.singleTable.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProjetoDelete {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            long projetoId = 1;
            
            em.getTransaction().begin();
            Projeto projeto = em.find(Projeto.class, projetoId);
            if (projeto != null) {
                em.remove(projeto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar projeto.");
        }
    }
}
