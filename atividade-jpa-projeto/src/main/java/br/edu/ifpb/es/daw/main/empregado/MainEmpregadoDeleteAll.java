package br.edu.ifpb.es.daw.main.empregado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Empregado").executeUpdate();
            em.getTransaction().commit();
            System.out.println("Empregados Apagados.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar Empregados");
        }
    }
}
