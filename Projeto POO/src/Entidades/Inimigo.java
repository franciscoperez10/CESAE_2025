package Entidades;

public abstract class Inimigo extends Personagem {

    protected int ouro;

    /**
     * Construtor que permite instanciar um Inimigo
     * Herda os atributos de Personagem
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     */

    public Inimigo(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
        this.ouro = ouro;
    }

    /**
     * Método abstrato que faz com os Inimigos também ataquem durante o jogo
     * Método que entra em ação depois do ataque do Herói
     * @param heroi
     */
    public abstract void atacar(Heroi heroi);


    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Método que faz com os Inimigos recebam danos
     * @param dano
     */
    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;
        System.out.println(nome + " recebeu " + dano + " de dano! Vida restante: " + vidaAtual);
    }


    public abstract void usarHabilidadeEspecial(Heroi heroi);

    /**
     * Método para mostrar os detalhes do Inimigo
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Inimigo: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Ouro: " + ouro);
    }
}
