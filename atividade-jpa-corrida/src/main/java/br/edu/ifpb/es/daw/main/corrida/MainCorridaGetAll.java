package br.edu.ifpb.es.daw.main.corrida;

import java.util.List;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaGetAll {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try {
            List<Corrida> corridas = corridaDAO.getAll();

            for (Corrida corrida : corridas) {
                System.out.println(corrida);
            }

        } catch (PersistenciaDawException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
