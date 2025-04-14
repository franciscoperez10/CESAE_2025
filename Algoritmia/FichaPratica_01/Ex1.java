import java.util.Scanner;

public class Main
{
    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);
        int numero1, numero2;
        String nome;

        System.out.print("Introduza um número: ");
        numero1 = input.nextInt();

        System.out.print("Introduza um número: ");
        numero2 = input.nextInt();

        System.out.println("Soma: " + (numero1 + numero2));

    }
}