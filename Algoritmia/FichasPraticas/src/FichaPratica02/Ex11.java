package FichaPratica02;

import java.util.Scanner;

public class Ex11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double saldo, movimento, saldoAposMovimento;

        System.out.println("Introduza saldo médio: ");
        saldo = input.nextDouble();

        System.out.println("Introduza valor a movimentar: ");
        movimento = input.nextDouble();

        saldoAposMovimento = (saldo + movimento);


        if (saldoAposMovimento >= 0) {
            System.out.println("Transação Aprovada ");
            System.out.println("Saldo atual: " + saldoAposMovimento);
        } else {
            System.out.println("Operação inválida. Saldo Insuficiente");
            System.out.println("Saldo atual: " + saldo);
        }

    }
}