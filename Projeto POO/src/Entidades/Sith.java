package Entidades;

public class Sith extends Inimigo {

    protected int ataque;
    protected int defesa;
    protected int poderForca;
    protected int danoSabreNegro;

    public Sith(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, int ataque, int poderForca, int danoSabreNegro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro);
        this.ataque = ataque;
        this.defesa = defesa;
        this.poderForca = poderForca;
        this.danoSabreNegro = danoSabreNegro;
    }

    @Override
    public void atacar(Heroi heroi) {
        int dano = this.forca + this.ataque;
        System.out.println(nome + " ataca com sabre de luz! Fez um dano de " + dano);
        heroi.receberDano(dano);
    }

    @Override
    public void usarHabilidadeEspecial(Heroi heroi) {
        int danoEspecial = (this.forca * 3 / 2) + this.poderForca;
        System.out.println(nome + " usa um poder da Força obscura! Fez um dano de " + danoEspecial);
        heroi.receberDano(danoEspecial);
    }

    public void usarSabreNegro(Heroi heroi) {
        int dano = this.danoSabreNegro + this.forca;
        System.out.println(nome + " ataca com o Sabre Negro! Dano: " + dano);
        heroi.receberDano(dano);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Sith: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Ataque: " + ataque + " | Poder da Força: " + poderForca + " | Dano Sabre Negro: " + danoSabreNegro);
    }
}
