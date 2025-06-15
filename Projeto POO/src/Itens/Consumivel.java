package Itens;

import Entidades.HeroisPermitidos;
import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {

    protected String descricao;
    protected int quantidade;

    public Consumivel(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> heroisPermitidos, String descricao, int quantidade) {
        super(nome, precoMoedasOuro, heroisPermitidos);
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public abstract void aplicarEfeito(Entidades.Heroi heroi);

    public abstract void mostrarDetalhes();
}
