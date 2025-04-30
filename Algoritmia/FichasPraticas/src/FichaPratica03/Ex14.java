package FichaPratica03;

import java.util.Scanner;

public class Ex14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numeroAnterior = 0, numeroAtual = 0, contador = 0;int i = 1;

        System.out.println("Quantos números deseja inserir: ");
        contador = input.nextInt();

        if (contador <= 0) {
            System.out.println("O número deve ser maior do que 0");
        }

        System.out.println("Introduza um número: ");
        numeroAnterior = input.nextInt();


        while (i < contador) {
            System.out.println("Introduza o próximo número: ");
            numeroAtual = input.nextInt();

            if (numeroAtual < numeroAnterior) {
                System.out.println("Ordem Não Crescente");
            } else System.out.println("Ordem Crescente");

            numeroAnterior = numeroAtual;
            i++;


        }

    }
}
