package br.edu.ifpb.es.daw.main.empregado;

import br.edu.ifpb.es.daw.entities.tablePerClass.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoDelete {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            
            long empregadoId = 1;
            
            em.getTransaction().begin();
            Empregado empregado = em.find(Empregado.class, empregadoId);
            if (empregado != null) {
                em.remove(empregado);
            }
            em.getTransaction().commit();
            System.out.println("Empregado: " + empregadoId + " apagado.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao apagar empregado.");
        }
    }
}
