package FichaPratica06;

import java.util.Scanner;

public class Ex06 {

    public static int maior(int[] vetor) {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    public static int menor(int[] vetor) {
        int menor = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    public static boolean eCrescente(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < vetor[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Qual o tamanho do vetor? ");
        int tamanho = input.nextInt();

        int[] vetor = new int[tamanho];


        System.out.println("Insira os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento [" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        int opcao;
        do {

            System.out.println("--- MENU DE OPÇÕES ---");
            System.out.println("1. Maior Elemento");
            System.out.println("2. Menor Elemento");
            System.out.println("3. Crescente ou Não Crescente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Maior elemento: " + maior(vetor));
                    break;
                case 2:
                    System.out.println("Menor elemento: " + menor(vetor));
                    break;
                case 3:
                    if (eCrescente(vetor)) {
                        System.out.println("O vetor está crescente.");
                    } else {
                        System.out.println("O vetor NÃO está crescente.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

}

