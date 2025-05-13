package FichaPratica03;

import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero, i;
        i = 0;

        System.out.println("Introduza o número: ");
        numero = input.nextInt();


        while (i <= numero) {

            System.out.println(i);
            i = i + 1;
        }
    }
}
