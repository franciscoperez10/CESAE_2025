package FichaPratica02;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numeroMenor, numeroMaior;

        System.out.println("Introduza um número: ");
        numeroMenor = input.nextInt();

        System.out.println("Introduza um número: ");
        numeroMaior = input.nextInt();

        if (numeroMenor < numeroMaior) {
            System.out.println(numeroMenor + " " + numeroMaior);
        } else {
            System.out.println(numeroMaior + " " + numeroMenor);


        }
    }
}
