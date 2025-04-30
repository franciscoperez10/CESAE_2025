package FichaPratica03;

import java.util.Scanner;

public class Ex09 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero = 0, soma = 0, contador = 0, media;


        while (numero != -1) {
            System.out.println("Introduza um número: ");
            numero = input.nextInt();
            soma = soma + numero;
            contador++;
        }

        media = soma / contador;
        System.out.println("Média: " + media);
    }
}
