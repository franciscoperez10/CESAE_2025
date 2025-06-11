package Entidades;

public abstract class Personagem {
    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;
    protected int nivel;
    protected int defesa;

    public Personagem(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.forca = forca;
        this.nivel = nivel;
        this.defesa = defesa;
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
    }

    public void curar(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > vidaMax) {
            vidaAtual = vidaMax;
        }
    }

    public boolean temVida() {
        return vidaAtual > 0;
    }

    public abstract void mostrarDetalhes();
}
