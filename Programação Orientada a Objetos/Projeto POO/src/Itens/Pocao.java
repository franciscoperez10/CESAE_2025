package Itens;

import Entidades.HeroisPermitidos;
import Entidades.Heroi;

import java.util.ArrayList;

/**
 * Classe que representa uma poção, usada para curar vida e/ou aumentar a força do herói.
 * Herda de Consumivel e adiciona atributos para quantidade de vida a curar e aumento de força.
 */
public class Pocao extends Consumivel {

    protected int vidaACurar;
    protected int aumentoDeForca;

    /**
     * Construtor da Poção
     *
     * @param nome
     * @param precoMoedasOuro
     * @param heroisPermitidos
     * @param descricao
     * @param quantidade
     * @param vidaACurar
     * @param aumentoDeForca
     */
    public Pocao(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> heroisPermitidos, String descricao, int quantidade, int vidaACurar, int aumentoDeForca) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade);
        this.vidaACurar = vidaACurar;
        this.aumentoDeForca = aumentoDeForca;
    }

    public int getAumentoDeForca() {
        return aumentoDeForca;
    }

    public void setAumentoDeForca(int aumentoDeForca) {
        this.aumentoDeForca = aumentoDeForca;
    }

    public int getVidaACurar() {
        return vidaACurar;
    }

    public void setVidaACurar(int vidaACurar) {
        this.vidaACurar = vidaACurar;
    }

    /**
     * Método que aplica o efeito da poção no herói.
     * Cura a vida (sem ultrapassar o máximo) e aumenta a força.
     * Mostra mensagens de feedback ao jogador.
     *
     * @param heroi
     */
    public void aplicarEfeito(Heroi heroi) {
        int vidaAntes = heroi.getVidaAtual();
        int vidaMax = heroi.getVidaMax();
        int vidaCurada = Math.min(vidaACurar, vidaMax - vidaAntes);
        heroi.setVidaAtual(vidaAntes + vidaCurada);
        heroi.setForca(heroi.getForca() + aumentoDeForca);

        System.out.println("Usou poção: +" + vidaCurada + " HP, +" + aumentoDeForca + " força.");
        if (vidaACurar > vidaCurada) {
            System.out.println("Atenção: Só foi possível curar até ao máximo de vida (" + vidaMax + ")");
        }
    }

    /**
     * Método que mostra os Detalhes de cada poção
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Poção: " + nome + " | Preço: " + precoMoedasOuro + " | Vida a curar: " + vidaACurar + " | Aumento de força: " + aumentoDeForca + " | Quantidade: " + quantidade + " | Descrição: " + descricao);
    }
}