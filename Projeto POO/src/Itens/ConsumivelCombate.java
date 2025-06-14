package Itens;

import Entidades.ClassesPermitidas;
import Entidades.Heroi;
import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {

    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> heroisPermitidos,
                             String descricao, int quantidade, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    @Override
    public void aplicarEfeito(Heroi heroi) {
        System.out.println("Consumível de combate usado! Ataque instantâneo: " + ataqueInstantaneo);
        // A lógica de subtrair o ataque ao inimigo deve ser feita no método de combate do herói
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Consumível de Combate: " + nome +
                " | Preço: " + precoMoedasOuro +
                " | Ataque Instantâneo: " + ataqueInstantaneo +
                " | Quantidade: " + quantidade +
                " | Descrição: " + descricao);
    }
}
