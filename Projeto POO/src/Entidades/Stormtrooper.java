package Entidades;

public class Stormtrooper extends Inimigo {

    protected int ataque;
    protected int armardura;

    public Stormtrooper(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int armardura) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.armardura = armardura;
    }

    public void mostrarDetalhes() {

    }

    public void dispararBlaster () {

    }

    public void pedirReforcos () {

    }

    public void fugir () {

    }
}
