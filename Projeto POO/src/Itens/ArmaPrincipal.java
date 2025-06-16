package Itens;


import Entidades.HeroisPermitidos;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    protected int ataque;
    protected int ataqueEspecial;

    public ArmaPrincipal(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> classesPermitidas, int ataque, int ataqueEspecial) {
        super(nome, precoMoedasOuro, classesPermitidas);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.print("Arma: " + nome + " | Preço: " + precoMoedasOuro + " | Ataque: " + ataque + " | Ataque Especial: " + ataqueEspecial + " | Classes permitidas: ");
        for (HeroisPermitidos heroi : classesPermitidas) {
            System.out.print(heroi + " ");
        }
        System.out.println();
    }

}
