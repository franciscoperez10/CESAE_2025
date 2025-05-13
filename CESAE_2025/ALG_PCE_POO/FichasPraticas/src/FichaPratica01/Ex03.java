package FichaPratica01;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int lado1, lado2;

        System.out.print("Introduza o valor do comprimento: ");
        lado1 = input.nextInt();

        System.out.print("Introduza o valor da largura: ");
        lado2 = input.nextInt();

        System.out.println("Perímetro: " + ((lado1 + lado2) + (lado1 + lado2)));
        System.out.println("Área: " + (lado1 * lado2));
    }
}
