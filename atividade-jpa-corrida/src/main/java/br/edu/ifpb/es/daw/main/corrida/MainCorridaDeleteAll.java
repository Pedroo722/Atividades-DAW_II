package br.edu.ifpb.es.daw.main.corrida;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaDeleteAll {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try {
            System.out.println("Deletando todas as corridas...");
            for (Corrida corrida : corridaDAO.getAll()) {
                corridaDAO.delete(corrida.getId());
            }
            System.out.println("Todas as corridas foram deletadas com sucesso!");

        } catch (PersistenciaDawException e) {
            System.out.println("Erro ao deletar corridas: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
