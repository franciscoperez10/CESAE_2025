package FichaPratica05;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[3][5];
        int num, total = 0;

        System.out.println("Insira um número na Matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int a = 0; a < matriz[i].length; a++) {
                matriz[i][a] = input.nextInt();
            }
        }

        System.out.println("Matriz preenchida:");
        for (int i = 0; i < matriz.length; i++) {
            for (int a = 0; a < matriz[i].length; a++) {
                System.out.print(matriz[i][a] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nInsira um número para pesquisar: ");
        num = input.nextInt();

        // Searching for occurrences
        for (int i = 0; i < matriz.length; i++) {
            for (int a = 0; a < matriz[i].length; a++) {
                if (matriz[i][a] == num) total++;
            }
        }

        System.out.printf("Há %d posições na matriz com o número %d\n", total, num);

        input.close(); // Close scanner to avoid resource leaks
    }
}
