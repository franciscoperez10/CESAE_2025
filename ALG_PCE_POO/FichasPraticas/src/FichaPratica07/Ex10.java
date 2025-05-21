package FichaPratica07;

import java.util.Scanner;

public class Ex10 {

    public static void menu(String[][] matriz) {

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Imprimir todos os formandos");
            System.out.println("2. Procurar formando por matrícula");
            System.out.println("3. Procurar formandos por curso");
            System.out.println("4. Imprimir aluno mais velho");
            System.out.println("5. Imprimir alunos inscritos em mais de um curso");
            System.out.println("6. Número total de formandos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");


            scanner.nextLine();

            switch (opcao) {
                case 1:
                    lista.imprimirTodosFormandos();
                    break;

                case 2:
                    System.out.println("Digite o número da matrícula: ");
                    int matricula = scanner.nextInt();
                    lista.procurarPorMatricula(matricula);

                case 3:
                    System.out.println("Digite o nome do curso: ");
                    String curso = scanner.nextLine();
                    lista.procurarPorCurso(curso);

                case 4:
                    lista.imprimirAlunoMaisVelho();

                case 5:
                    lista.imprimirAlunosComMaisDeUmCurso();

                case 6:
                    lista.imprimirNumeroDeFormandos();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        } while (opcao != 0);

        scanner.close();


    }
}

