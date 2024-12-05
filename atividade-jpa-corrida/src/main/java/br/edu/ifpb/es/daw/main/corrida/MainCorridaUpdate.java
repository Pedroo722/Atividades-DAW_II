package br.edu.ifpb.es.daw.main.corrida;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import br.edu.ifpb.es.daw.entities.StatusCorrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaUpdate {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o ID da corrida que deseja atualizar: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // para consomir a quebra de linha, se n dar erro

            Corrida corrida = corridaDAO.getByID(id);
            if (corrida == null) {
                System.out.println("Corrida com ID " + id + " não encontrada.");
                return;
            }

            System.out.println("Corrida encontrada: " + corrida);

            System.out.print("Atualizar nome da corrida (" + corrida.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isBlank()) {
                corrida.setNome(novoNome);
            }

            System.out.print("Atualizar data de realização (" + corrida.getDataRealizacao() + ") (yyyy-MM-dd): ");
            String novaData = scanner.nextLine();
            if (!novaData.isBlank()) {
                corrida.setDataRealizacao(java.sql.Date.valueOf(novaData));
            }

            System.out.println("Atualizar status da corrida (atual: " + corrida.getStatus() + "):");
            for (StatusCorrida status : StatusCorrida.values()) {
                System.out.println("- " + status);
            }
            System.out.print("Digite o novo status ou pressione Enter para manter o atual: ");
            String novoStatus = scanner.nextLine();
            if (!novoStatus.isBlank()) {
                corrida.setStatus(StatusCorrida.valueOf(novoStatus.toUpperCase()));
            }

            System.out.print("Deseja atualizar o grid de largada? (s/n): ");
            String atualizarGrid = scanner.nextLine();
            if (atualizarGrid.equalsIgnoreCase("s")) {
                Map<Integer, String> novoGrid = new HashMap<>();
                String continuar;
                do {
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine(); // para consumir a quebra de linha, se n dar erro

                    System.out.print("Digite o nome do piloto: ");
                    String piloto = scanner.nextLine();
                    novoGrid.put(posicao, piloto);

                    System.out.print("Deseja adicionar mais pilotos? (s/n): ");
                    continuar = scanner.nextLine();
                } while (continuar.equalsIgnoreCase("s"));
                corrida.setGridLargada(novoGrid);
            }

            corridaDAO.update(corrida);

            System.out.println("Corrida atualizada com sucesso:");
            System.out.println(corrida);

        } catch (PersistenciaDawException e) {
            System.out.println("Erro ao atualizar a corrida: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
