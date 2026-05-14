package org.example;

import dao.IAlunoDAO;
import daoImplements.AlunoDAOImplements;
import daoImplements.TurmaDAOImplements;
import dataBase.sqlConn;
import model.Aluno;
import model.Turma;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        sqlConn.testConnection();

        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        TurmaDAOImplements turmaDaoMethods = new TurmaDAOImplements();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Atualizar aluno");
            System.out.println("3. Excluir aluno");
            System.out.println("4. Listar aluno");
            System.out.println("5. Listar aluno por ID");
            System.out.println("6. Listar turma por ID");
            System.out.println("0. Sair do programa");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de aluno");

                    System.out.println("Nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Cpf: ");
                    String cpf = sc.nextLine();

                    System.out.println("Email: ");
                    String email = sc.nextLine();

                    System.out.println("Data de Nascimento: ");
                    LocalDate  data_nascimento;

                    try {
                        data_nascimento = LocalDate.parse(sc.nextLine());
                    } catch (Exception e ) {
                        throw new RuntimeException("Erro de data. Tente: aaaa-mm--dd");
                    }

                    System.out.println("Telefone");
                    String telefone = sc.nextLine();

                    Aluno alunoNovo = new Aluno(nome, cpf, email, data_nascimento, telefone);
                    alunoDaoMethods.salvar(alunoNovo);

                    break;
                case 2:
                    System.out.println("Atualizar aluno");
                    break;
                case 3:
                    System.out.println("Excluir aluno");
                    break;
                case 4:
                    System.out.println("Listar aluno");

                    List<Aluno> todosAlunos = alunoDaoMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Aluno aluno : todosAlunos) {
                            System.out.println(aluno);

                        }
                    }
                    break;
                case 5:
                    System.out.println("Listar Aluno por ID. Informe um IDpara pesquisar: ");
                    int idBusca = sc.nextInt();

                    Optional<Aluno> alunoEncontrado = alunoDaoMethods.obterPorId(idBusca);

                    if (alunoEncontrado.isPresent()) {
                        System.out.println(alunoEncontrado.get());
                    }else {
                        System.out.println("Nenhum aluno encontrado!");

                    }
                    break;

                case 6:
                    System.out.println("Listar turmas");

                    List<Turma> todasTurmas = turmaDaoMethods.listarTodasTurmas();

                    if (todasTurmas.isEmpty()) {
                        System.out.println("Nenhuma turma encontrada");
                    } else {
                        for (Turma turma : todasTurmas) {
                            System.out.println(turma);
                        }
                    }

                    System.out.println("Informe o id da turma para visualizar os alunos:");
                    int idInformado = sc.nextInt();

                    List<Aluno> alunosTurmaEncontrada = turmaDaoMethods.listarAlunoPorTurmaID(idInformado);

                    if (alunosTurmaEncontrada.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado nesta turma!");
                    } else {
                        System.out.println("Alunos matriculados: ");
                        for (Aluno aluno : alunosTurmaEncontrada) {
                            System.out.println(aluno);
                        }
                    }

                    break;
            }


        } while ((opcao != 0));
    }
    // implementar um novo metodo para buscar aluno por id (retornando assim apenas um unico aluno ao inves de todos)
    // menu - 5 opcoes (salvar, excluir, atualizar, listartodos, listarporid)


}