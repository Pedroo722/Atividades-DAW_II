package br.edu.ifpb.es.daw.main.projeto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProjetoDeleteAll {
	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
		EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Projeto").executeUpdate();
			em.getTransaction().commit();
			System.out.println("Projetos apagados.");
		} catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar projetos.");
        }
	}
}
	