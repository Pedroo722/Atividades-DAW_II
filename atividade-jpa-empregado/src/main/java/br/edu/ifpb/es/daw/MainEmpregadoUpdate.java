package br.edu.ifpb.es.daw;

import java.util.Scanner;

import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoUpdate {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
			Scanner scanner = new Scanner(System.in);) {
            EntityManager em = emf.createEntityManager();

			System.out.print("\n\n\nDigite o ID do empregado a ser atualizado: ");
            Long idToUpdate = scanner.nextLong();

            Empregado empregado = em.find(Empregado.class, idToUpdate);
            if (empregado != null) {
                em.getTransaction().begin();

                empregado.setNome("Updated João");
                empregado.setSobrenome("Updated Silva");
                empregado.setDataNascimento(empregado.getDataNascimento().plusDays(1)); 

                em.getTransaction().commit();

                System.out.println("Empregado atualizado: " + empregado);
            } else {
                System.out.println("Empregado não encontrado com o ID: " + idToUpdate);
            }
        }
    }
}
