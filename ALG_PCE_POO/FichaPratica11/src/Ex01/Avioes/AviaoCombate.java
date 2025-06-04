package Ex01.Avioes;

import Ex01.Enums.Arma;

import java.util.ArrayList;

public class AviaoCombate extends Aviao {
    private String paisOrigem;
    private boolean camuflagem;
    private ArrayList<Arma> arsenal;

    public AviaoCombate(int serial, String modelo, int anoFabrico, double peso, double cmpFuselagem, double envAsas, double altCauda, int numMotores, double autonomia, double velocidadeMax, double preco, String paisOrigem, boolean camuflagem, ArrayList<Arma> arsenal) {
        super(serial, modelo, anoFabrico, peso, cmpFuselagem, envAsas, altCauda, numMotores, autonomia, velocidadeMax, preco);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.arsenal = new ArrayList<Arma>();
    }

    public void adicionarArma(Arma armaNova) {
        if (this.arsenal.size() < 3) {
            this.arsenal.add(armaNova);

        }
    }

    public void removerArma(Arma armaRemover) {
        this.arsenal.remove(armaRemover);
    }

    public void exibirDetalhes() {

    }
}
