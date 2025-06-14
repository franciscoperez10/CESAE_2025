package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;

public class Rebel extends Heroi {

    protected int ataque;
    protected int defesa;

    public Rebel(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia, int ataque) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro, armaPrincipal, inventario, habilidadeEspecial, experiencia);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public boolean atacar(Inimigo inimigo) {
        while (this.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
            // Herói ataca primeiro
            int danoHeroi = this.forca;
            if (this.armaPrincipal != null) {
                danoHeroi += this.armaPrincipal.getAtaque();
            }
            System.out.println(this.nome + " ataca! Dano: " + danoHeroi);
            inimigo.receberDano(danoHeroi);

            if (inimigo.getVidaAtual() <= 0) {
                System.out.println("O inimigo foi derrotado!");
                return true;
            }

            // Inimigo ataca
            int danoInimigo = inimigo.getForca();
            System.out.println(inimigo.getNome() + " ataca! Dano: " + danoInimigo);
            this.receberDano(danoInimigo);

            if (this.getVidaAtual() <= 0) {
                System.out.println("Foste derrotado pelo inimigo!");
                return false;
            }
        }
        return false;
    }


    @Override
    public void defender() {
        System.out.println(nome + "executa uma posição defensiva!");
    }

    @Override
    public void usarPocao() {
        System.out.println(nome + " usa uma poção rebelde!");
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa " + habilidadeEspecial + "!");
    }

    @Override
    public void usarItem(ItemHeroi item) {
        System.out.println(nome + " usa o item: " + item.getNome());
    }

    public void mudarArma() {
        System.out.println(nome + " troca de arma!");
    }

    public void reforcarDefesa() {
        System.out.println(nome + " reforça a sua posição defensiva!");
    }

    public void usarGranada() {
        System.out.println(nome + " atira uma granada!");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Rebel: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia + " | Ataque: " + ataque + " | Defesa: " + defesa);
    }

}
