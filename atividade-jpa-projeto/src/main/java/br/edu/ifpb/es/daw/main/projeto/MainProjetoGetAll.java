package br.edu.ifpb.es.daw.main.projeto;

import java.util.List;

import br.edu.ifpb.es.daw.entities.singleTable.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProjetoGetAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            List<Projeto> projetos = em.createQuery("SELECT e FROM Projeto e", Projeto.class).getResultList();
            projetos.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao recuperar projetos.");
        }
    }
}
