package FichaPratica01;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double valor1, valor2, valor3; // Declarar valores de cada
        double mediaAritmetica, mediaPonderada;

        System.out.println("Introduza o valor 1: ");
        valor1 = input.nextDouble();

        System.out.println("Introduza o valor 2: ");
        valor2 = input.nextDouble();

        System.out.println("Introduza o valor 3: ");
        valor3 = input.nextDouble();

        mediaAritmetica = (valor1 + valor2 + valor3) / 3;

        System.out.println("Média Aritmética: " + mediaAritmetica);

        mediaPonderada = (valor1 * 0.2) + (valor2 * 0.3) + (valor3 * 0.5);
        System.out.println("Média Ponderada: " + mediaPonderada);

    }
}
