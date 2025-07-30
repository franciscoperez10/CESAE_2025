package Itens;

import Entidades.HeroisPermitidos;

import java.util.ArrayList;

/**
 * Classe abstrata para todos os itens que podem ser usados por heróis.
 * Define atributos comuns como nome, preço e classes de heróis permitidas.
 * É estendida para ArmaPrincipal e Consumivel.
 */
public abstract class ItemHeroi {
    protected String nome;
    protected int precoMoedasOuro;
    protected ArrayList<HeroisPermitidos> classesPermitidas;

    /**
     * Construtor do ItemHeroi
     *
     * @param nome
     * @param precoMoedasOuro
     * @param classesPermitidas
     */
    public ItemHeroi(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> classesPermitidas) {
        this.nome = nome;
        this.precoMoedasOuro = precoMoedasOuro;
        this.classesPermitidas = classesPermitidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrecoMoedasOuro() {
        return precoMoedasOuro;
    }

    public void setPrecoMoedasOuro(int precoMoedasOuro) {
        this.precoMoedasOuro = precoMoedasOuro;
    }

    // Lista de classes de heróis que podem usar este item
    public ArrayList<HeroisPermitidos> getClassesPermitidas() {
        return classesPermitidas;
    }

    public void setClassesPermitidas(ArrayList<HeroisPermitidos> classesPermitidas) {
        this.classesPermitidas = classesPermitidas;
    }

    /**
     * Método que mostra os detalhes básicos do item, como o nome, o preço e as classes permitidas.
     * Pode ser sobrescrito nas subclasses para mostrar detalhes adicionais.
     */
    public void mostrarDetalhes() {
        System.out.print("Nome: " + nome + " | Preço: " + precoMoedasOuro + " | Classes permitidas: ");
        for (HeroisPermitidos heroisPermitidos1 : classesPermitidas) {
            System.out.print(heroisPermitidos1 + " ");
        }
        System.out.println();
    }


}
