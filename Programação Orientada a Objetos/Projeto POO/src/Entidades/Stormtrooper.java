package Entidades;


import java.util.Random;

/**
 * Classe que representa um inimigo Stormtrooper no jogo.
 * Herda de Inimigo e adiciona atributos específicos como ataque, defesa e armadura.
 */
public class Stormtrooper extends Inimigo {
    // Atributos específicos do Stormtrooper
    protected int ataque;
    protected int defesa;
    protected int armadura;

    /**
     * Construtor do Stormtrooper
     *
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     * @param ataque
     * @param armadura
     */

    public Stormtrooper(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int armadura) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.armadura = armadura;
    }


    /**
     * Método de ataque pelo Stormtrooper, para o Herói
     *
     * @param heroi
     * @return true se o Stormtrooper ganhar, caso contrário, false
     */
    @Override
    public void atacar(Heroi heroi) {
        int dano = this.forca + this.ataque;
        System.out.println(nome + " dispara com o blaster! Fez um dano de " + dano);
        heroi.receberDano(dano);
    }

    /**
     * Método que permite o Stormtrooper use um ataque específico. Não usado no resultado final.
     *
     * @param heroi
     */
    public void dispararBlaster(Heroi heroi) {
        Random random = new Random();
        int chance = random.nextInt(100); // 0 a 99
        if (chance < 80) {
            int dano = this.ataque + this.forca;
            System.out.println(nome + " dispara o blaster e acerta! Dano: " + dano);
            heroi.receberDano(dano);
        } else {
            System.out.println(nome + " dispara o blaster mas falha o tiro!");
        }
    }

    /**
     * Método que executa a habilidade especial do Stormtrooper. Não usado no resultado final.
     *
     * @param heroi Herói a ser atacado
     */
    @Override
    public void usarHabilidadeEspecial(Heroi heroi) {

        int danoEspecial = this.ataque * 2 + this.forca;
        System.out.println(nome + " usa ataque especial de blaster! Dano especial: " + danoEspecial);
        heroi.receberDano(danoEspecial);
    }

    /**
     * Método que permite o Stormtrooper abandonar o combate. Não usado no resultado final.
     *
     * @return true se conseguir fugir, false se não conseguir escapar
     */
    public boolean fugir() {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 30) {
            System.out.println(nome + " foge do combate com sucesso!");
            return true;
        } else {
            System.out.println(nome + " tenta fugir, mas não consegue escapar!");
            return false;
        }
    }

    /**
     * Método para mostrar os Detalhes do Stormtrooper
     */
    public void mostrarDetalhes() {
        System.out.println("Stormtrooper: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Ataque: " + ataque + " | Armadura: " + armadura);
    }
}
