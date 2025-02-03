package br.edu.ifpb.es.daw.main.empregado;

import br.edu.ifpb.es.daw.entities.tablePerClass.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoGetById {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        EntityManager em = emf.createEntityManager()) {
            long empregadoId = 1;
            Empregado empregado = em.find(Empregado.class, empregadoId);
            
            if (empregado != null) {
                System.out.println(empregado);
            } else {
                System.out.println("Empregado não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar empregado.");
        }
    }
}
