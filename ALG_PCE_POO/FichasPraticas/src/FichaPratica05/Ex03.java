package FichaPratica05;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] vetor = new int[10];
        int maior = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite 10 números: ");
            vetor[i] = input.nextInt();
        }
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > vetor[maior]) {
                maior = i;
            }
        }

        System.out.println("O maior elemento é: " + vetor[maior]);


    }
}