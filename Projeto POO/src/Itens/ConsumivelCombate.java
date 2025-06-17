package Itens;

/**
 * Classe que representa um consumível de combate.
 * Pode ser usado para infligir dano instantâneo ao inimigo.
 */

import Entidades.HeroisPermitidos;
import Entidades.Heroi;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {

    private int ataqueInstantaneo;

    /**
     * Construtor do ConsumivelCombate
     *
     * @param nome
     * @param precoMoedasOuro
     * @param heroisPermitidos
     * @param descricao
     * @param quantidade
     * @param ataqueInstantaneo
     */
    public ConsumivelCombate(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> heroisPermitidos, String descricao, int quantidade, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    /**
     * Método para aplicar efeitos especiais nos combates. Não utilizado no resultado final.
     *
     * @param heroi
     */
    public void aplicarEfeito(Heroi heroi) {
        System.out.println("Consumível de combate usado! Ataque instantâneo: " + ataqueInstantaneo);

    }

    /**
     * Método para mostrar os detalhes dos Consumíveis de Combate
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Consumível de Combate: " + nome + " | Preço: " + precoMoedasOuro + " | Ataque Instantâneo: " + ataqueInstantaneo + " | Quantidade: " + quantidade + " | Descrição: " + descricao);
    }
}