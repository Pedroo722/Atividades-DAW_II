package br.edu.ifpb.es.daw.main.corrida;

import java.util.Scanner;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaDelete {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\n\nDigite o ID da corrida a ser deletada: ");
            Long id = scanner.nextLong();

            System.out.println();
            System.out.println();

            corridaDAO.delete(id);
            System.out.println("Corrida com ID " + id + " foi deletada com sucesso!");

        } catch (PersistenciaDawException e) {
            System.out.println("Erro ao deletar corrida: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
