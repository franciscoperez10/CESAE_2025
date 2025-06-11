package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;

import java.util.ArrayList;

public class Rebel extends Heroi {

    protected int ataque;
    protected int defesa;

    public Rebel(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int nivel1, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int ataque, int defesa1) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, nivel1, ouro, armaPrincipal, inventario, habilidadeEspecial);
        this.ataque = ataque;
        this.defesa = defesa1;
    }

    @Override
    public void atacar() {
        super.atacar();
    }

    public void mudarArma() {

    }

    public void reforcarDefesa () {

    }

    public void usarGranada () {

    }

}
