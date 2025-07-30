package FichaPratica05;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetor = new int[10];
        int sum = 0;
        double avg = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite 10 números: ");
            vetor[i] = input.nextInt();
        }

        for (int i = 0; i < vetor.length; i++) {
            sum += vetor[i];
        }
        avg = ((double) sum / vetor.length);

        System.out.println("A média dos elementos é: " + avg);


    }
}

