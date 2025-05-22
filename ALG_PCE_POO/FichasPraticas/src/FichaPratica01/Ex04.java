package FichaPratica01;

import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double raio; // Declarar variável do raio
        double area; // Declarar variável da área, que vai gerar o resultado final

        System.out.println("Introduza o valor do raio: ");
        raio = input.nextInt();

        area = 3.14 * Math.pow(raio, 2); // Definir o valor da área, que vai ser Pi * (raio, elevado a 2)

        System.out.println("Área: " + area);


    }
}
