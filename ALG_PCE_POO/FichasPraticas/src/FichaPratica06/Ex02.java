package FichaPratica06;

import java.util.Scanner;

public class Ex02 {
    public static void imprimirAsteriscos(int numero) {
        for (int i = 0; i < numero; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numeroPositivo;

        do {
            System.out.print("Introduza um número inteiro positivo: ");


            while (!input.hasNextInt()) {
                System.out.print("Entrada inválida. Introduza um número inteiro: ");
                input.next();
            }

            numeroPositivo = input.nextInt();


            if (numeroPositivo <= 0) {
                System.out.println("O número deve ser positivo.");
            }
        } while (numeroPositivo <= 0);


        imprimirAsteriscos(numeroPositivo);


    }


}