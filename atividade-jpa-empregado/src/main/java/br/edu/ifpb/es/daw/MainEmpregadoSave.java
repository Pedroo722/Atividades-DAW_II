package br.edu.ifpb.es.daw;

import java.time.LocalDate;
import java.util.UUID;

import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
		) {
            EntityManager em = emf.createEntityManager();

            Empregado empregado = new Empregado();
            empregado.setNome("João");
            empregado.setSobrenome("Silva");

			String cpf = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 11);
            empregado.setCpf(cpf); // CPF gerado automaticamente
			System.out.println(empregado);

			empregado.setDataNascimento(LocalDate.of(2023, 1, 1));

            em.getTransaction().begin();
            em.persist(empregado);
            em.getTransaction().commit();

            System.out.println("Empregado salvo: " + empregado);
        }
    }
}