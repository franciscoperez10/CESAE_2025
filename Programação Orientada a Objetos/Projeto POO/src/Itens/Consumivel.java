package Itens;

/**
 * Classe abstrata que representa um item consumível (poção ou item de combate).
 * Herda de ItemHeroi e adiciona atributos para descrição e quantidade.
 * É posteriormente estendida para classes concretas como Pocao ou ConsumivelCombate.
 */

import Entidades.HeroisPermitidos;

import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {

    protected String descricao;
    protected int quantidade;

    /**
     * Construtor do Consumível
     *
     * @param nome
     * @param precoMoedasOuro
     * @param heroisPermitidos
     * @param descricao
     * @param quantidade
     */
    public Consumivel(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> heroisPermitidos, String descricao, int quantidade) {
        super(nome, precoMoedasOuro, heroisPermitidos);
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    /**
     * Método abstrato que mostra os Detalhes do consumível
     * Será implementada nas respetivas subclasses
     */
    public abstract void mostrarDetalhes();
}
