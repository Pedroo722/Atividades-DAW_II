package br.edu.ifpb.es.daw.main.empregado;

import br.edu.ifpb.es.daw.entities.tablePerClass.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoSave {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            Empregado empregado = new Empregado();
            empregado.setNome("João Silva");
    
            em.getTransaction().begin();
            em.persist(empregado);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao salvar Empregados");
        }
    }
}
