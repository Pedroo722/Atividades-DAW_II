package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MainEmpregadoGetAll {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EntityManager em = emf.createEntityManager();

            TypedQuery<Empregado> query = em.createQuery("SELECT e FROM Empregado e", Empregado.class);
            List<Empregado> empregados = query.getResultList();

            System.out.println("All empregados:");
            for (Empregado empregado : empregados) {
                System.out.println(empregado);
            }
        }
    }
}