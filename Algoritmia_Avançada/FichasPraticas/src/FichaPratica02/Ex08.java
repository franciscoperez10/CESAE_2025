package FichaPratica02;

import java.util.Scanner;

public class Ex08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double nota1, nota2, nota3;
        double mediaPonderada;

        System.out.println("Introduza a primeira nota: ");
        nota1 = input.nextInt();

        System.out.println("Introduza a segunda nota: ");
        nota2 = input.nextInt();

        System.out.println("Introduza a terceira nota: ");
        nota3 = input.nextInt();

        mediaPonderada = (nota1 * 0.25 + nota2 * 0.35 + nota3 * 0.4);

        System.out.println("Média Ponderada: " + mediaPonderada);

        if (mediaPonderada >= 9.5) {
            System.out.println("O aluno está aprovado");
        } else {
            System.out.println("O aluno está reprovado");
        }
    }
}