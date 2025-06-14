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

    public ArrayList<ClassesPermitidas> getClassesPermitidas() {
        return classesPermitidas;
    }

    public void setClassesPermitidas(ArrayList<ClassesPermitidas> classesPermitidas) {
        this.classesPermitidas = classesPermitidas;
    }

    public void mostrarDetalhes() {
        System.out.print("Nome: " + nome + " | Preço: " + precoMoedasOuro + " | Classes permitidas: ");
        for (ClassesPermitidas classesPermitidas1 : classesPermitidas) {
            System.out.print(classesPermitidas1 + " ");
        }
        System.out.println();
    }


}
