package Itens;

import Entidades.ClassesPermitidas;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {

    protected int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> heroisPermitidos, String descricao, int quantidade, String tipo, int duracao, String efeito, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade, tipo, duracao, efeito);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }
}
