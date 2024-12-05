package br.edu.ifpb.es.daw.main.corrida;

import java.util.Scanner;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaGetById {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\n\nDigite o ID da Corrida: ");
            Long id = scanner.nextLong();

            System.out.println();
            System.out.println();
            
            Corrida corrida = corridaDAO.getByID(id);

            if (corrida != null) {
                System.out.println(corrida);
            } else {
                System.out.println("Corrida não encontrada com ID: " + id);
            }

        } catch (PersistenciaDawException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
