package Entidades;

/**
 * Classe abstrata, que serve como "base" para os Heróis e os Inimigos
 * Super classe de Heróis e Inimigos
 * Definie atributos comuns às personagens
 *
 */

public abstract class Personagem {
    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;
    protected int nivel;
    protected int defesa;

    /**
     * Construtor para instanciar as personagens
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     */
    public Personagem(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.forca = forca;
        this.nivel = nivel;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * Método que faz com que a personagem (seja Herói ou Inimigo) receba danos
     * @param dano
     */
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

    /**
     * Método que mostra os Detalhes da personagem (seja Heroi ou Inimigo)
     * Método que é subscrito nas respetivas subclasses
     */

    public abstract void mostrarDetalhes();
}
