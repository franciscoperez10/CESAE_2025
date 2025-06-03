package Ex_03;

public class Main {
    public static void main(String[] args) {
        Peixe peixe1 = new Peixe("pescada", 40, 5.5);
        Peixe peixe2 = new Peixe("robalo", 60, 7.5);
        Peixe peixe3 = new Peixe("salmão", 25, 8.5);
        Peixe peixe4 = new Peixe("sardinha", 45, 2.8);

        Marisco marisco1 = new Marisco("sapateira", 10, 4.5);
        Marisco marisco2 = new Marisco("lavagante", 20, 9.5);
        Marisco marisco3 = new Marisco("lagosta", 15, 1.5);
        Marisco marisco4 = new Marisco("caranguejo-verde", 12.5, 6.5);

        BarcoPesca barcoPesca1 = new BarcoPesca("Pérola Negra", "preto", 2005, 50, 500, "QUICKSILVER");


        barcoPesca1.pescarPeixe(peixe1);
        barcoPesca1.pescarPeixe(peixe2);
        barcoPesca1.pescarPeixe(peixe3);
        barcoPesca1.pescarPeixe(peixe4);

        barcoPesca1.pescarMarisco(marisco1);
        barcoPesca1.pescarMarisco(marisco2);
        barcoPesca1.pescarMarisco(marisco3);
        barcoPesca1.pescarMarisco(marisco4);

        System.out.println("\nTotal pescado: " + barcoPesca1.calcularTotal() + "€");
        System.out.println("Salário por tripulante: " + barcoPesca1.salarioTripulacao() + "€");
    }
}
