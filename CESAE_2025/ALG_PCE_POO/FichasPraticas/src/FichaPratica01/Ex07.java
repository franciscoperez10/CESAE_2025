package FichaPratica01;

import java.util.Scanner;

public class Ex07 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double produto1, produto2, produto3;
        double valorDesconto, valorTotal;

        System.out.print("Introduza o valor do produto 1: ");
        produto1 = input.nextDouble();

        System.out.print("Introduza o valor do produto 2: ");
        produto2 = input.nextDouble();

        System.out.print("Introduza o valor do produto 3: ");
        produto3 = input.nextDouble();

        valorDesconto = (produto1 + produto2 + produto3) * 0.1;
        valorTotal = (produto1 + produto2 + produto3) - valorDesconto;
        System.out.println("Valor Total: " + valorTotal);
    }
}
