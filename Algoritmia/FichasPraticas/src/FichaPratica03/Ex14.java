package FichaPratica03;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Ex14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numeroAnterior = 0, numeroAtual = 0, contador = 0, i = 1;
        boolean flag = true;

        do {
            System.out.println("Quantos números deseja inserir: ");
            contador = input.nextInt();
            if (contador <= 0) {
                System.out.println("O número deve ser maior do que 0");
                }
        } while (contador <= 0);

        System.out.println("Introduza um número: ");
        numeroAnterior = input.nextInt();

        for (i=1; i < contador; i++) {
            System.out.println("Introduza o próximo número: ");
            numeroAtual = input.nextInt();

            if (numeroAtual < numeroAnterior) {
                flag = false;
            }
            numeroAnterior = numeroAtual;
        }
        if (flag == true) {
            System.out.println("Ordem Crescente");
        } else {
            System.out.println("Ordem Não Crescente");
        }
    }
}
