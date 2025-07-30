package FichaPratica01;

import java.util.Scanner;

public class Ex06 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int valor1, valor2;


        System.out.println("Introduza o valor 1: ");
        valor1 = input.nextInt();

        System.out.println("Introduza o valor 2: ");
        valor2 = input.nextInt();

        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        System.out.println("Após a troca: ");
        System.out.println("Valor 1: " + valor1);
        System.out.println("Valor 2: " + valor2);
    }
}
