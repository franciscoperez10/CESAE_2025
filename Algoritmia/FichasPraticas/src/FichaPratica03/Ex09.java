package FichaPratica03;

import java.util.Scanner;

public class Ex09 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero, soma = 0, contador;

        System.out.println("Introuza um número (-1 para terminar o programa): ");
        numero = input.nextInt();

        while (numero != -1) {
            soma = soma + numero;
            System.out.println("Introduza outro número: ");
        }


    }
}
