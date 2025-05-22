package FichaPratica05;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int somaElementos = 0;

        System.out.println("Introduza os elementos da matriz: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int a = 0; a < 5; a++) {
                matriz[i][a] = input.nextInt();
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int a = 0; a < 5; a++) {
                somaElementos = somaElementos + matriz[i][a];
                System.out.println(matriz[i][a]);
            }


        }

        System.out.println("A soma dos elementos é de: " + somaElementos);

    }

}

