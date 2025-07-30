package FichaPratica05;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] comissoes = new double[12];
        double totalAnual = 0;

        for (int i = 0; i < 12; i++) {
            System.out.println("Qual a comissão para o mês de " + (i + 1) + ": ");
            comissoes[i] = input.nextDouble();
        }



        for (int i = 0; i < comissoes.length; i++) {


            totalAnual = totalAnual + comissoes[i];
        }

        System.out.println("O total anual de comissões é: " + totalAnual);
    }
}

