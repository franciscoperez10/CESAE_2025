package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;

public class Jedi extends Heroi {

    protected int danoForca;
    protected int danoSabre;
    protected int pontosForca;

    public Jedi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia, int danoForca, int danoSabre, int pontosForca) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro, armaPrincipal, inventario, habilidadeEspecial, experiencia);
        this.danoForca = danoForca;
        this.danoSabre = danoSabre;
        this.pontosForca = pontosForca;
    }

    @Override
    public boolean atacar(Inimigo inimigo) {

        while (this.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {

            int danoInimigo = (int) (inimigo.getForca() * 0.8);
            System.out.println(inimigo.getNome() + " ataca! Dano: " + danoInimigo);
            this.receberDano(danoInimigo);

            if (this.getVidaAtual() <= 0) {
                System.out.println("Foste derrotado pelo inimigo!");
                return false;
            }


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
        }

        return false;
    }


    @Override
    public void defender() {
        System.out.println(nome + " usa o poder da Força para defender!");
    }

    @Override
    public void usarPocao() {
        System.out.println(nome + " usa uma poção.");
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa " + habilidadeEspecial + "!");
    }

    @Override
    public void usarItem(ItemHeroi item) {
        System.out.println(nome + " usa o item: " + item.getNome());
    }


    public void usarPoderForca() {
        System.out.println(nome + " usa o poder da Força!");

    }

    public void usarSabreLuz() {
        System.out.println(nome + " ataca com o sabre de luz!");

    }

    public void bloquearTiros() {
        System.out.println(nome + " bloqueia tiros com o sabre de luz!");

    }

    public void mostrarDetalhes() {
        System.out.println("Jedi: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia + " | Dano Força: " + danoForca + " | Dano Sabre: " + danoSabre);
    }
}
