package FichaPratica05;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[3][3];

        System.out.println("Digite 9 números inteiros: ");
        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                matriz[i][a] = input.nextInt();
            }
        }

        System.out.println("Matriz inserida:");
        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                System.out.print(matriz[i][a] + "\t");
            }
            System.out.println();

        }
    }
}
