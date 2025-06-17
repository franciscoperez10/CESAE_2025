package Entidades;

public class Separatist extends Inimigo {
    // Atributos específicos do Separatist
    protected int ataque;
    protected int defesa;
    protected int poderFogo;
    protected int escudo;

    /**
     * Construtor do Separatist
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     * @param ataque
     * @param poderFogo
     * @param escudo
     */

    public Separatist(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int poderFogo, int escudo) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.poderFogo = poderFogo;
        this.escudo = escudo;
    }

    /**
     * Método de ataque pelo Separatist, para o Herói
     * @param heroi
     * return true se o Separatist ganhar, caso contrário, false
     */
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

    /**
     * Método que imprime os Detalhes do Separatist
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Separatist: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Ataque: " + ataque + " | Poder de Fogo: " + poderFogo + " | Escudo: " + escudo);
    }
}
