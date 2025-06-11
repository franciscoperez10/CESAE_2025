package Entidades;

public class Sith extends Inimigo {

    protected int poderForca;
    protected int danoSabre;

    public Sith(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int poderForca, int danoSabre) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.poderForca = poderForca;
        this.danoSabre = danoSabre;
    }

    public void mostrarDetalhes() {

    }

    public void usarPoderForca () {

    }

    public void usarSabreNegro() {

    }

    public void fugir () {

    }




}
