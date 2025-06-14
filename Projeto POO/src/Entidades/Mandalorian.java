package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;

public class Mandalorian extends Heroi {

    protected int combustivelJetPack;
    protected int durabilidadeArmadura;
    protected int slugthrowers;

    public Mandalorian(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia, int combustivelJetPack, int durabilidadeArmadura, int slugthrowers) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro, armaPrincipal, inventario, habilidadeEspecial, experiencia);
        this.combustivelJetPack = combustivelJetPack;
        this.durabilidadeArmadura = durabilidadeArmadura;
        this.slugthrowers = slugthrowers;
    }

    @Override
    public boolean atacar(Inimigo inimigo) {
        while (this.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
            // Herói ataca primeiro (sempre ataque normal)
            int danoHeroi = this.forca;
            if (this.armaPrincipal != null) {
                danoHeroi = danoHeroi + this.armaPrincipal.getAtaque();
            }
            System.out.println(this.nome + " ataca! Dano: " + danoHeroi);
            inimigo.receberDano(danoHeroi);

            if (inimigo.getVidaAtual() <= 0) {
                System.out.println("O inimigo foi derrotado!");
                this.nivel = this.nivel + 1;
                this.vidaMax = this.vidaMax + 10;
                this.vidaAtual = this.vidaAtual + 10;
                this.forca = this.forca + 1;
                this.ouro = this.ouro + inimigo.getOuro();
                return true;
            }

            // Inimigo ataca (+10% de dano)
            int danoInimigo = inimigo.getForca();
            int bonus = (int) (danoInimigo * 0.1);
            danoInimigo = danoInimigo + bonus;
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
        System.out.println(nome + " usa a armadura para defender o ataque! A durabilidade restante é: " + durabilidadeArmadura);

    }

    @Override
    public void usarPocao() {
        System.out.println(nome + " usa uma poção mandaloriana!");
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa " + habilidadeEspecial + "!");
    }

    @Override
    public void usarItem(ItemHeroi item) {
        System.out.println(nome + " usa o item: " + item.getNome());
    }

    public void usarJetPack() {
        if (combustivelJetPack > 0) {
            System.out.println(nome + " voa com o jetpack! Combustível restante: " + (--combustivelJetPack));
        } else {
            System.out.println(nome + " está sem combustível no jetpack!");
        }
    }

    public void usarSlugthrowers() {
        System.out.println(nome + " usa slugthrowers para disparar!");

    }

    public void mudarArma() {
        System.out.println(nome + " troca de arma!");
    }

    public void reforcarArmadura() {
        durabilidadeArmadura += 10;
        System.out.println(nome + " reforça a armadura! A durabilidade atual é de: " + durabilidadeArmadura);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Mandalorian: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax +
                " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro +
                " | Experiência: " + experiencia + " | Combustível JetPack: " + combustivelJetPack +
                " | Durabilidade Armadura: " + durabilidadeArmadura + " | Slugthrowers: " + slugthrowers);
    }
}
