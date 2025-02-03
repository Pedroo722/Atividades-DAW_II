package br.edu.ifpb.es.daw.main.veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainVeiculoDeleteAll {
	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
		EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Veiculo").executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar veiculos.");
        }
	}
}
	