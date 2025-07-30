package FichaPratica02;

import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int salario;

        System.out.println("Introduza um salário: ");
        salario = input.nextInt();

        if (salario <= 15000) {
            System.out.println("Paga taxa de 20%: " + (salario * 0.2));
        }
        if (salario > 15000 && salario <= 20000) {
            System.out.println("Paga taxa de 30%: " + (salario * 0.3));
        }

        if (salario > 20000 && salario <= 25000) {
            System.out.println("Paga taxa de 35%: " + (salario * 0.35));
        }

        if (salario > 25000) {
            System.out.println("Paga taxa de 40%: " + (salario * 0.40));

        }


    }
}