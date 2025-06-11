package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;

import java.util.ArrayList;

public class Jedi extends Heroi {

    protected int danoForca;
    protected int danoSabre;
    protected int pontosForca;

    public Jedi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int nivel1, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int danoForca, int danoSabre, int pontosForca) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, nivel1, ouro, armaPrincipal, inventario, habilidadeEspecial);
        this.danoForca = danoForca;
        this.danoSabre = danoSabre;
        this.pontosForca = pontosForca;
    }

    @Override
    public void atacar(Inimigo inimigo) {
        super.atacar();
    }

    public void usarPoderForca() {

    }

    public void usarSabreLuz () {

    }

    public void bloquearTiros () {

    }


}
