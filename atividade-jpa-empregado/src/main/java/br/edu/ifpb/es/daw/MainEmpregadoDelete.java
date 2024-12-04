package br.edu.ifpb.es.daw;

import java.util.Scanner;

import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoDelete {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
			Scanner scanner = new Scanner(System.in);) {

            EntityManager em = emf.createEntityManager();

			System.out.print("\n\n\nDigite o ID do empregado a ser deletado: ");
            Long idToDelete = scanner.nextLong();

            Empregado empregado = em.find(Empregado.class, idToDelete);
            if (empregado != null) {
                em.getTransaction().begin();
                em.remove(empregado);
                em.getTransaction().commit();
                System.out.println("Empregado deletado: " + empregado);
            } else {
                System.out.println("Empregado não encontrado com ID: " + idToDelete);
            }
        }
    }
}