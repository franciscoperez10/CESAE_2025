package Entidades;

/**
 * Classe que representa um inimigo Sith no jogo.
 * Herda de Inimigo e adiciona atributos como ataque, poder da força e dano do sabre negro.
 */

public class Sith extends Inimigo {
    // Atributos específicos dos Sith
    protected int ataque;
    protected int defesa;
    protected int poderForca;
    protected int danoSabreNegro;

    /**
     * Construtor dos Sith
     *
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     * @param ataque
     * @param poderForca
     * @param danoSabreNegro
     */

    public Sith(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int poderForca, int danoSabreNegro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.poderForca = poderForca;
        this.danoSabreNegro = danoSabreNegro;
    }

    /**
     * Método de ataque pelo Separatist, para o Herói
     *
     * @param heroi return true se o Separatist ganhar, caso contrário, false
     */

    @Override
    public void atacar(Heroi heroi) {
        int dano = this.forca + this.ataque;
        System.out.println(nome + " ataca com o Sabre de Luz negro! Fez um dano de " + dano);
        heroi.receberDano(dano);
    }

    /**
     * Método para a habilidade especial dos Sith. Não usado no resultado final.
     *
     * @param heroi
     */

    @Override
    public void usarHabilidadeEspecial(Heroi heroi) {
        int danoEspecial = (this.forca * 3 / 2) + this.poderForca;
        System.out.println(nome + " usa um poder da Força obscura! Fez um dano de " + danoEspecial);
        heroi.receberDano(danoEspecial);
    }

    /**
     * Método para a utilização de uma arma (Sabre Negro) dos Sith. Não usado no resultado final.
     *
     * @param heroi
     */

    public void usarSabreNegro(Heroi heroi) {
        int dano = this.danoSabreNegro + this.forca + 25;
        System.out.println(nome + " ataca com o Sabre de Luz Negro! Dano: " + dano);
        heroi.receberDano(dano);
    }

    /**
     * Método que imprime os Detalhes do Sith, após cada jogada
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Sith: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Ataque: " + ataque + " | Poder da Força: " + poderForca + " | Dano Sabre Negro: " + danoSabreNegro);
    }
}
