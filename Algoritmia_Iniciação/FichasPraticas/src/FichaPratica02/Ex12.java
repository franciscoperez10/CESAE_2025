package FichaPratica02;

import java.util.Scanner;

public class Ex12 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int opcao;

        System.out.println("***** Menu *****");
        System.out.println("1. Criar");
        System.out.println("2. Atualizar");
        System.out.println("3. Eliminar");
        System.out.println("4. Sair");

        System.out.print("Insira a sua opção: ");
        opcao= input.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Criar");
                break;

            case 2:
                System.out.println("Atualizar");
                break;

            case 3:
                System.out.println("Eliminar");
                break;

            case 4:
                break;

            default:
                System.out.println("Opção Inválida");
        }

    }
}