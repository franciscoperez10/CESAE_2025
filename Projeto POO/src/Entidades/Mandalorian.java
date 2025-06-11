package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;

import java.util.ArrayList;

public class Mandalorian extends Heroi {

    protected int combustivelJetPack;
    protected int durabilidadeArmadura;
    protected int slugthrowers;

    public Mandalorian(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int nivel1, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int combustivelJetPack, int durabilidadeArmadura, int slugthrowers) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, nivel1, ouro, armaPrincipal, inventario, habilidadeEspecial);
        this.combustivelJetPack = combustivelJetPack;
        this.durabilidadeArmadura = durabilidadeArmadura;
        this.slugthrowers = slugthrowers;
    }

    @Override
    public void atacar() {
        super.atacar();
    }

    public void usarJetPack() {

    }

    public void usarSlugthrowers() {


    }

    public void mudarArma () {

    }

    public void reforcarArmadura () {

    }


}
