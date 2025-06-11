package Itens;

import Entidades.ClassesPermitidas;
import Entidades.Heroi;

import java.util.ArrayList;

public class Consumivel extends ItemHeroi {

    protected String descricao;
    protected int quantidade;
    protected String tipo;
    int duracao;
    String efeito;

    public Consumivel(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> heroisPermitidos, String descricao, int quantidade, String tipo, int duracao, String efeito) {
        super(nome, precoMoedasOuro, heroisPermitidos);
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.duracao = duracao;
        this.efeito = efeito;
    }

    public void aplicarEfeito () {

    }

    public void removerEfeito () {

    }
}
