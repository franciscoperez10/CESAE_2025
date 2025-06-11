package Itens;

import Entidades.ClassesPermitidas;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int precoMoedasOuro;
    protected ArrayList<ClassesPermitidas> classesPermitidas;

    public ItemHeroi(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> classesPermitidas) {
        this.nome = nome;
        this.precoMoedasOuro = precoMoedasOuro;
        this.classesPermitidas = classesPermitidas;
    }

    public void mostrarDetalhes() {

    }
}
