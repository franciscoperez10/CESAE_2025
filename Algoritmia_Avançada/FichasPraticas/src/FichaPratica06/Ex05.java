package FichaPratica06;

import java.util.Scanner;

public class Ex05 {

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
    }
}
