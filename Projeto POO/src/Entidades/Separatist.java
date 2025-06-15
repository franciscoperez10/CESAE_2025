package Entidades;

public class Separatist extends Inimigo {

    protected int ataque;
    protected int defesa;
    protected int poderFogo;
    protected int escudo;

    public Separatist(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int poderFogo, int escudo) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.poderFogo = poderFogo;
        this.escudo = escudo;
    }

    @Override
    public void atacar(Heroi heroi) {
        int dano = this.forca + this.ataque + this.poderFogo;
        System.out.println(nome + " dispara com poder de fogo máximo! Dano: " + dano);
        heroi.receberDano(dano);
    }

    @Override
    public void usarHabilidadeEspecial(Heroi heroi) {
        int danoEspecial = this.poderFogo * 2 + this.forca - heroi.defesa;
        if (danoEspecial < 0) danoEspecial = 0;
        System.out.println(nome + " ativa o canhão de energia! Dano especial: " + danoEspecial);
        heroi.receberDano(danoEspecial);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Separatist: " + nome +
                " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Ataque: " + ataque + " | Poder de Fogo: " + poderFogo + " | Escudo: " + escudo);
    }
}
