package FichaPratica03;

import java.util.Scanner;

public class Ex08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero, contador;

        System.out.println("Introduza um número: ");
        numero = input.nextInt();

        contador = numero - 5;

        while (contador < numero) {

            System.out.println(contador + " ");
            contador = contador + 1;

        }

        contador = numero + 1;

        while (contador <= numero + 5) {

            System.out.println(contador + " ");
            contador = contador + 1;
        }

    }
}
