package br.edu.ifpb.es.daw.main.corrida;

import java.util.HashMap;
import java.util.Scanner;

import br.edu.ifpb.es.daw.dao.CorridaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CorridaDAOImpl;
import br.edu.ifpb.es.daw.entities.Corrida;
import br.edu.ifpb.es.daw.entities.StatusCorrida;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCorridaSave {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");

        CorridaDAO corridaDAO = new CorridaDAOImpl(emf);

        try (Scanner scanner = new Scanner(System.in)) {
            Corrida corrida = new Corrida();

            System.out.print("\n\nDigite o nome da corrida: ");
            corrida.setNome(scanner.nextLine());

            System.out.print("Digite a data de realização (yyyy-MM-dd): ");
            String dataInput = scanner.nextLine();
            corrida.setDataRealizacao(java.sql.Date.valueOf(dataInput));

            System.out.println("Escolha o status da corrida:");
            for (StatusCorrida status : StatusCorrida.values()) {
                System.out.println("- " + status);
            }
            System.out.print("Digite o status: ");
            corrida.setStatus(StatusCorrida.valueOf(scanner.nextLine().toUpperCase()));

            System.out.println("Adicione o grid de largada:");
            HashMap<Integer, String> gridLargada = new HashMap<>();
            String continuar;
            do {
                System.out.print("Digite a posição: ");
                int posicao = scanner.nextInt();
                scanner.nextLine(); // somente para consomir a quebra de linha, se n dar erro

                System.out.print("Digite o nome do piloto: ");
                String piloto = scanner.nextLine();
                gridLargada.put(posicao, piloto);

                System.out.print("Deseja adicionar mais pilotos? (s/n): ");
                continuar = scanner.nextLine();
            } while (continuar.equalsIgnoreCase("s"));
            corrida.setGridLargada(gridLargada);

            corridaDAO.save(corrida);

            System.out.println("Corrida salva com sucesso:");
            System.out.println(corrida);

        } catch (PersistenciaDawException e) {
            System.out.println("Erro ao salvar a corrida: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}
