package FichaPratica03;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numero, i;
        i = 1;
        String mensagem;

        System.out.println("Introduza um número: ");
        numero = input.nextInt();

        System.out.print("Introduza uma mensagem: ");
        input.nextLine(); // Limpar o Buffer, para garantir que a 2ª mensagem imprime
        mensagem = input.nextLine();


        while (i <= numero) {

            System.out.println(mensagem);
            i = i + 1;
        }


    }
}
