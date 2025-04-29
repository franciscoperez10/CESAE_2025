import java.util.Scanner;

public class Ex12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero, contador0_25 = 0, contador_26_50 = 0, contador51_75 = 0, contador76_100 = 0;

        System.out.println("Introduza um número - (negativo para terminar o programa): ");
        numero = input.nextInt();

        while (numero >= 0) {
            if (numero <= 25) {
                contador0_25++;
            } else if (numero <= 50) {
                contador_26_50++;
            } else if (numero <= 75) {
                contador51_75++;
            } else if (numero <= 100) {
                contador76_100++;
            }

            System.out.println("Introduza um número - (negativo para terminar o programa): ");
            numero = input.nextInt();
        }

        System.out.println("[0-25]: " + contador0_25);
        System.out.println("[26-50]: " + contador_26_50);
        System.out.println("[51-75]: " + contador51_75);
        System.out.println("[76-100]: " + contador76_100);
    }
}
