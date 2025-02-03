package br.edu.ifpb.es.daw.main.empregado;

import br.edu.ifpb.es.daw.entities.tablePerClass.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoUpdate {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw"); 
        EntityManager em = emf.createEntityManager()) {
            long empregadoId = 1;
            
            em.getTransaction().begin();
            Empregado empregado = em.find(Empregado.class, empregadoId);
            if (empregado != null) {
                empregado.setNome("Carlos Andrade");
                em.merge(empregado);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao atualizar Empregados");
        }
    }
}
