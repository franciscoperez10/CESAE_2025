package Ex_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Taco> stock = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1. Taco de Carne de Frango");
            System.out.println("2. Taco de Carne de Vaca");
            System.out.println("3. Taco Vegetariano");
            System.out.println("0. Sair");
            System.out.print("\nEscolha a opção: ");
            opcao = input.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                String tipo = switch (opcao) {
                    case 1 -> "frango";
                    case 2 -> "vaca";
                    case 3 -> "vegetariano";
                    default -> throw new IllegalArgumentException();
                };
                Taco taco = FabricaTacos.criarTaco(tipo);
                taco.prepare();
                taco.bake();
                taco.box();
                stock.add(taco);
            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        input.close();
    }
}
