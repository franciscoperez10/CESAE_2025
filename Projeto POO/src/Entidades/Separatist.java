package Entidades;

public class Separatist extends Inimigo {

    protected int poderFogo;
    protected int escudo;

    public Separatist(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int poderFogo, int escudo) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.poderFogo = poderFogo;
        this.escudo = escudo;
    }

    public void mostrarDetalhes() {

    }

    public void dispararArma() {

    }

    public void ativarEscudo() {

    }

    public void autoReparar () {

    }

    public void fugir () {

    }

}
