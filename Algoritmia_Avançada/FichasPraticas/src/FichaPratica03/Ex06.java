package FichaPratica03;

import java.util.Scanner;

public class Ex06 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int inicio, fim;

        System.out.println("Introduza um número de início: ");
        inicio = input.nextInt();

        System.out.println("Introduza um numero de fim: ");
        fim = input.nextInt();

        while (inicio <= fim) {

            System.out.println(inicio);
            inicio = inicio + 1;
        }

    }
}
