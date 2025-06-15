package Entidades;

import java.util.Random;

public class Stormtrooper extends Inimigo {

    protected int ataque;
    protected int defesa;
    protected int armadura;

    public Stormtrooper(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int armadura) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.armadura = armadura;
    }


    @Override
    public void atacar(Heroi heroi) {
        int dano = this.forca + this.ataque;
        System.out.println(nome + " dispara com o blaster! Fez um dano de " + dano);
        heroi.receberDano(dano);
    }

    public void dispararBlaster(Heroi heroi) {
        Random rand = new Random();
        int chance = rand.nextInt(100); // 0 a 99
        if (chance < 80) {
            int dano = this.ataque + this.forca;
            System.out.println(nome + " dispara o blaster e acerta! Dano: " + dano);
            heroi.receberDano(dano);
        } else {
            System.out.println(nome + " dispara o blaster mas falha o tiro!");
        }
    }

    @Override
    public void usarHabilidadeEspecial(Heroi heroi) {

        int danoEspecial = this.ataque * 2 + this.forca;
        System.out.println(nome + " usa ataque especial de blaster! Dano especial: " + danoEspecial);
        heroi.receberDano(danoEspecial);
    }


    public boolean fugir() {
        Random random = new Random();
        int chance = random.nextInt(100); // 0 a 99
        if (chance < 30) {
            System.out.println(nome + " foge do combate com sucesso!");
            return true;
        } else {
            System.out.println(nome + " tenta fugir, mas não consegue escapar!");
            return false;
        }
    }
}
