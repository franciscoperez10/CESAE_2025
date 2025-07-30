package Ex03;

public class IngredientePizza {
    private Ingrediente ingrediente;
    private double quantidade;

    public IngredientePizza(Ingrediente ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotalKcal() {
        return ingrediente.getNumKcal() * quantidade;
    }

    public String descricaoDetalhada() {


        ingrediente.getCodigo();
        ingrediente.getNome();
        ingrediente.getUnidadeDeMedida();
        ingrediente.getNumKcal();

    }


}
