package Ex03;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Pizza {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private ArrayList<IngredientePizza> ingredientePizzas;

    public Pizza(int codigo, String nome, String descricao, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.ingredientePizzas = new ArrayList<>();
    }

    public void addIngrediente(Ingrediente ingredienteNovo, double quantidade) {
        if (this.ingredientePizzas.size() < 5) {
            this.ingredientePizzas.add(new IngredientePizza(ingredienteNovo, quantidade));
        } else {
            System.out.println("Limite de ingredientes atingido");
        }
    }

    public void editarIngrediente() {

    }

    public boolean removeIngrediente(String Ingrediente) {
        this.removeIngrediente();
    }

    public double numeroKcal() {
        double total = 0;
        for (IngredientePizza ip : ingredientePizzas) {
            total += ip.getTotalKcal();
        }
        return total;
    }


    public void exibirDetalhes() {

    }
}
