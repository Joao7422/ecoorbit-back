package br.com.ecoorbit.app;

import br.com.ecoorbit.dao.AlertaAmbientalDAO;
import br.com.ecoorbit.dao.AreaMonitoradaDAO;
import br.com.ecoorbit.dao.UsuarioDAO;
import br.com.ecoorbit.model.AlertaAmbiental;
import br.com.ecoorbit.model.AreaMonitorada;
import br.com.ecoorbit.model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        AreaMonitoradaDAO areaDAO = new AreaMonitoradaDAO();
        AlertaAmbientalDAO alertaDAO = new AlertaAmbientalDAO();

        int opcao;

        do {
            System.out.println("\n===== ECOORBIT =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Cadastrar área monitorada");
            System.out.println("4 - Listar áreas monitoradas");
            System.out.println("5 - Cadastrar alerta ambiental");
            System.out.println("6 - Listar alertas ambientais");
            System.out.println("7 - Atualizar usuário");
            System.out.println("8 - Deletar usuário");
            System.out.println("9 - Atualizar área monitorada");
            System.out.println("10 - Deletar área monitorada");
            System.out.println("11 - Atualizar alerta ambiental");
            System.out.println("12 - Deletar alerta ambiental");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Tipo de usuário: ");
                    String tipo = scanner.nextLine();

                    Usuario usuario = new Usuario(nome, email, tipo);
                    usuarioDAO.cadastrar(usuario);
                }

                case 2 -> {
                    System.out.println("\n=== USUÁRIOS ===");
                    for (Usuario usuario : usuarioDAO.listar()) {
                        System.out.println(usuario);
                    }
                }

                case 3 -> {
                    System.out.print("Nome da área: ");
                    String nome = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("Tamanho em hectares: ");
                    double tamanho = scanner.nextDouble();

                    System.out.print("ID do usuário responsável: ");
                    int usuarioId = scanner.nextInt();
                    scanner.nextLine();

                    AreaMonitorada area = new AreaMonitorada(nome, cidade, estado, tamanho, usuarioId);
                    areaDAO.cadastrar(area);
                }

                case 4 -> {
                    System.out.println("\n=== ÁREAS MONITORADAS ===");
                    for (AreaMonitorada area : areaDAO.listar()) {
                        System.out.println(area);
                    }
                }

                case 5 -> {
                    System.out.print("Tipo do alerta: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Nível de risco: ");
                    String nivelRisco = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("ID da área monitorada: ");
                    int areaId = scanner.nextInt();
                    scanner.nextLine();

                    AlertaAmbiental alerta = new AlertaAmbiental(
                            tipo,
                            nivelRisco,
                            descricao,
                            LocalDate.now(),
                            areaId
                    );

                    alertaDAO.cadastrar(alerta);
                }

                case 6 -> {
                    System.out.println("\n=== ALERTAS AMBIENTAIS ===");
                    for (AlertaAmbiental alerta : alertaDAO.listar()) {
                        System.out.println(alerta);
                    }
                }

                case 7 -> {
                    System.out.print("ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String email = scanner.nextLine();

                    System.out.print("Novo tipo: ");
                    String tipo = scanner.nextLine();

                    Usuario usuario = new Usuario(id, nome, email, tipo);
                    usuarioDAO.atualizar(usuario);
                }

                case 8 -> {
                    System.out.print("ID do usuário para deletar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    usuarioDAO.deletar(id);
                }

                case 9 -> {
                    System.out.print("ID da área: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome da área: ");
                    String nome = scanner.nextLine();

                    System.out.print("Nova cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Novo estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("Novo tamanho em hectares: ");
                    double tamanho = scanner.nextDouble();

                    System.out.print("ID do usuário responsável: ");
                    int usuarioId = scanner.nextInt();
                    scanner.nextLine();

                    AreaMonitorada area = new AreaMonitorada(id, nome, cidade, estado, tamanho, usuarioId);
                    areaDAO.atualizar(area);
                }

                case 10 -> {
                    System.out.print("ID da área para deletar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    areaDAO.deletar(id);
                }

                case 11 -> {
                    System.out.print("ID do alerta: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo tipo do alerta: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Novo nível de risco: ");
                    String nivelRisco = scanner.nextLine();

                    System.out.print("Nova descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("ID da área monitorada: ");
                    int areaId = scanner.nextInt();
                    scanner.nextLine();

                    AlertaAmbiental alerta = new AlertaAmbiental(
                            id,
                            tipo,
                            nivelRisco,
                            descricao,
                            LocalDate.now(),
                            areaId
                    );

                    alertaDAO.atualizar(alerta);
                }

                case 12 -> {
                    System.out.print("ID do alerta para deletar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    alertaDAO.deletar(id);
                }

                case 0 -> System.out.println("Encerrando o EcoOrbit...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}