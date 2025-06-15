package Entidades;

public abstract class Inimigo extends Personagem {

    protected int ouro;

    public Inimigo(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
        this.ouro = ouro;
    }

    public abstract void atacar(Heroi heroi);


    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;
        System.out.println(nome + " recebeu " + dano + " de dano! Vida restante: " + vidaAtual);
    }


    public abstract void usarHabilidadeEspecial(Heroi heroi);

    @Override
    public void mostrarDetalhes() {
        System.out.println("Inimigo: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Ouro: " + ouro);
    }
}
