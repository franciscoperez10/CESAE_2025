package Itens;

import Entidades.ClassesPermitidas;

import java.util.ArrayList;

public class Pocao extends Consumivel {

    protected int vidaACurar;
    protected int aumentoDeForca;

    public Pocao(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> heroisPermitidos, String descricao, int quantidade, String tipo, int duracao, String efeito, int vidaACurar, int aumentoDeForca) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade, tipo, duracao, efeito);
        this.vidaACurar = vidaACurar;
        this.aumentoDeForca = aumentoDeForca;
    }
}


