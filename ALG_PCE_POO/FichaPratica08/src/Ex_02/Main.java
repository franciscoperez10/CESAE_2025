package Ex_02;

public class Main {
    public static void main(String[] args) {

        Edificio edificio1 = new Edificio(9, "Pinheiro Manso", "Rua do Pinheiro", "Porto", "Azul e branca", true);

        edificio1.mostrarInformacoes();
        System.out.println("");

        edificio1.setCorDaFachada("Branco");
        edificio1.mostrarInformacoes();

    }
}
