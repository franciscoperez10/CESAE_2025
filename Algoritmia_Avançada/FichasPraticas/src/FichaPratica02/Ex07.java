package FichaPratica02;

import java.util.Scanner;

public class Ex07 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero1;

        System.out.println("Introduza o número: ");
        numero1 = input.nextInt();

        if (numero1 % 2 == 0) {
            System.out.println("O número é par");
        } else {
            System.out.println("O número é impar");
        }


    }
}
