package FichaPratica03;

import java.util.Scanner;

public class Ex13 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int inicio, fim;

        System.out.println("Introduza o valor inicial: ");
        inicio = input.nextInt();

        System.out.println("Introduza o valor final: ");
        fim = input.nextInt();

        System.out.println("Múltiplos de 5 no intervalo [" + inicio + ", " + fim + "] são:");

        inicio += (5 - inicio % 5);

        while (inicio <= fim) {
            System.out.println(inicio);
            inicio += 5;
        }


    }

}
