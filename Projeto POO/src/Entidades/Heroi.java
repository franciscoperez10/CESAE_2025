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

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Consumivel> inventario) {
        this.inventario = inventario;
    }

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public boolean atacar(Inimigo inimigo) {
        if (this.getVidaAtual() > 0) {
            return true;
        } else {
            return false;
        }
    }

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

    @Override
    public void mostrarDetalhes() {
        System.out.print("Herói: " + nome +
                " | Nível: " + nivel +
                " | Vida: " + vidaAtual + "/" + vidaMax +
                " | Força: " + forca +
                " | Defesa: " + defesa +
                " | Ouro: " + ouro +
                " | Experiência: " + experiencia);

        System.out.print(" | Arma Principal: ");
        if (armaPrincipal != null) {
            System.out.print(armaPrincipal.getNome());
        } else {
            System.out.print("Nenhuma");
        }
        System.out.println();
    }


}

