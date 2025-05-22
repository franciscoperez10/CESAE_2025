package FichaPratica05;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] vetor = new int[10];
        boolean crescente = true;

        // Leitura dos elementos do vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Insira no vetor [" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        // Verificação se o vetor está em ordem crescente
        for (int i = 1; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                crescente = false;
                break;
            }
        }

        // Exibição do resultado
        if (crescente) {
            System.out.println("Os elementos estão em ordem crescente.");
        } else {
            System.out.println("Os elementos não estão em ordem crescente.");
        }

        input.close();
    }
}
