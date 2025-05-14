package FichaPratica05;

import java.util.Scanner;

public class Ex11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int maior, menor;

        System.out.println("Insira 9 números para preencher a matriz:");
        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                matriz[i][a] = input.nextInt();
            }
        }

        maior = menor = matriz[0][0];

        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                if (matriz[i][a] > maior) {
                    maior = matriz[i][a];
                }
                if (matriz[i][a] < menor) {
                    menor = matriz[i][a];
                }
            }
        }

        System.out.println("Matriz preenchida:");
        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                System.out.print(matriz[i][a] + " ");
            }
            System.out.println();
        }

        System.out.print("Maior valor: " + maior);
        System.out.print("Menor valor: " + menor);


    }

}
