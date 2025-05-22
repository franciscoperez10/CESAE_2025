package FichaPratica02;

import java.util.Scanner;

public class Ex06 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero1, numero2;

        System.out.println("Introduza o primeiro número: ");
        numero1 = input.nextInt();

        System.out.println("Introduza o segundo número: ");
        numero2 = input.nextInt();

        if (numero1 > numero2) {
            System.out.println("Maior: " + numero1);
            System.out.println("Menor: " + numero2);
        } else {
            System.out.println("Maior: " + numero2);
            System.out.println("Menor: " + numero1);
        }
    }
}
