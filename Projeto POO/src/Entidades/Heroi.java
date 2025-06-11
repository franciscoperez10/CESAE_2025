package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;

public abstract class Heroi extends Personagem {

    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;
    protected String habilidadeEspecial;
    protected int experiencia;

    public Heroi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = inventario;
        this.habilidadeEspecial = habilidadeEspecial;
        this.experiencia = experiencia;
    }

    public abstract void atacar(Inimigo inimigo);

    public abstract void defender();

    public abstract void usarPocao();

    public abstract void usarHabilidadeEspecial();

    public void ganharXP(int xp) {
        this.experiencia += xp;
        System.out.println(nome + " ganhou" + xp + " pontos de experiência. Tem agora um total de " + experiencia + ".");
        if (this.experiencia >= experienciaParaProximoNivel()) {
            subirNivel();
        }
    }

    public int experienciaParaProximoNivel() {
        return this.nivel * 10;
    }

    public void subirNivel() {
        this.nivel++;
        this.experiencia = 0;
        this.vidaMax += 10;
        this.vidaAtual = this.vidaMax;
        this.forca += 2;
        this.defesa += 1;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }


    public abstract void usarItem(ItemHeroi item);

    public abstract void mostrarDetalhes();


}

