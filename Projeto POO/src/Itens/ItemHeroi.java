package Itens;

import Entidades.HeroisPermitidos;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int precoMoedasOuro;
    protected ArrayList<HeroisPermitidos> classesPermitidas;

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

    public ArrayList<HeroisPermitidos> getClassesPermitidas() {
        return classesPermitidas;
    }

    public void setClassesPermitidas(ArrayList<HeroisPermitidos> classesPermitidas) {
        this.classesPermitidas = classesPermitidas;
    }

    public void mostrarDetalhes() {
        System.out.print("Nome: " + nome + " | Preço: " + precoMoedasOuro + " | Classes permitidas: ");
        for (HeroisPermitidos heroisPermitidos1 : classesPermitidas) {
            System.out.print(heroisPermitidos1 + " ");
        }
        System.out.println();
    }


}
