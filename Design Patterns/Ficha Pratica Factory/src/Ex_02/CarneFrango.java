package Ex_02;

public class CarneFrango extends Taco {
    public CarneFrango(String descricao) {
        super(descricao);
    }

    @Override
    public void prepare() {
        System.out.println("\nA preparar taco de: " + super.descricao);

    }

    @Override
    public void bake() {
        System.out.println("\nA cozinhar taco de: " + super.descricao);
    }

    @Override
    public void box() {
        System.out.println("\nA embalar taco de: " + super.descricao);
    }
}
