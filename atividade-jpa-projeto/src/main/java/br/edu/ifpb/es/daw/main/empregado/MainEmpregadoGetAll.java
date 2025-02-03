package br.edu.ifpb.es.daw.main.empregado;

import java.util.List;

import br.edu.ifpb.es.daw.entities.tablePerClass.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoGetAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            List<Empregado> empregados = em.createQuery("SELECT e FROM Empregado e", Empregado.class).getResultList();
            empregados.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao recuperar empregado.");
        }
    }
}
