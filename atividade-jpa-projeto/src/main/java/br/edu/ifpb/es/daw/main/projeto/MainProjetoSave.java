package br.edu.ifpb.es.daw.main.projeto;

import br.edu.ifpb.es.daw.entities.singleTable.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProjetoSave {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            Projeto projeto = new Projeto();
            projeto.setNome("Projeto A");
            
            em.getTransaction().begin();
            em.persist(projeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao salvar projeto.");
        }
    }
}
