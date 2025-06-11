package Entidades;

public abstract class Inimigo extends Personagem {

    protected int ouro;

    public Inimigo(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
        this.ouro = ouro;
    }
}
