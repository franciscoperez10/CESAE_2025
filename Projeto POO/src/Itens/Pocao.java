package Itens;

import Entidades.ClassesPermitidas;
import Entidades.Heroi;
import java.util.ArrayList;

public class Pocao extends Consumivel {

    protected int vidaACurar;
    protected int aumentoDeForca;

    public Pocao(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> heroisPermitidos,
                 String descricao, int quantidade, int vidaACurar, int aumentoDeForca) {
        super(nome, precoMoedasOuro, heroisPermitidos, descricao, quantidade);
        this.vidaACurar = vidaACurar;
        this.aumentoDeForca = aumentoDeForca;
    }

    @Override
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

    @Override
    public void mostrarDetalhes() {
        System.out.println("Poção: " + nome +
                " | Preço: " + precoMoedasOuro +
                " | Vida a curar: " + vidaACurar +
                " | Aumento de força: " + aumentoDeForca +
                " | Quantidade: " + quantidade +
                " | Descrição: " + descricao);
    }
}
