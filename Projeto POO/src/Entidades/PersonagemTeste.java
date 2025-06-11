package Entidades;


public class PersonagemTeste extends Personagem {
    public PersonagemTeste(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
    }


    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome + " | Vida: " + vidaAtual + "/" + vidaMax +
                " | Força: " + forca + " | Nível: " + nivel + " | Defesa: " + defesa);
    }
}
