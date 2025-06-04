package Ex01.Avioes;

import Ex01.Enums.CategoriaJato;
import Ex01.Enums.InstalacaoJato;

import java.util.ArrayList;

public class JatoPrivado extends Aviao {
    private int lotacao;
    private double capacidade_bagagem;
    private CategoriaJato categoria;
    private ArrayList<InstalacaoJato> comodidades;

    public JatoPrivado(int serial, String modelo, int anoFabrico, double peso, double cmpFuselagem, double envAsas, double altCauda, int numMotores, double autonomia, double velocidadeMax, double preco, int lotacao, double capacidade_bagagem, CategoriaJato categoria, ArrayList<InstalacaoJato> comodidades) {
        super(serial, modelo, anoFabrico, peso, cmpFuselagem, envAsas, altCauda, numMotores, autonomia, velocidadeMax, preco);
        this.lotacao = lotacao;
        this.capacidade_bagagem = capacidade_bagagem;
        this.categoria = categoria;
        this.comodidades = new ArrayList<InstalacaoJato>();
    }

    public void adicionarInstalacao (InstalacaoJato instalacaoNova) {
        this.comodidades.add(instalacaoNova);
    }

    public void removerInstalacao (InstalacaoJato instalacaoRemover) {
        this.comodidades.remove(instalacaoRemover);
    }

    public void exibirDetalhes() {

    }
}
