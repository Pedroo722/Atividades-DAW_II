package br.edu.ifpb.es.daw.main.projeto;

import br.edu.ifpb.es.daw.entities.singleTable.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProjetoGetByID {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            long projetoId = 1;
            Projeto projeto = em.find(Projeto.class, projetoId);
            
            if (projeto != null) {
                System.out.println(projeto);
            } else {
                System.out.println("Projeto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao recuperar projeto pelo ID.");
        }
    }
}