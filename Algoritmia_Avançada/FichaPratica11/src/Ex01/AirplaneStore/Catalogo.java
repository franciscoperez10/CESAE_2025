package Ex01.AirplaneStore;

import Ex01.Avioes.Aviao;

import java.util.ArrayList;

public class Catalogo {

    private ArrayList<Aviao> avioesDisponiveis;

    public Catalogo(ArrayList<Aviao> avioesDisponiveis) {
        this.avioesDisponiveis = new ArrayList<Aviao>();
    }

    public void adquirirAviao(Aviao aviaoNovo) {
        this.avioesDisponiveis.add(aviaoNovo);
    }

    public void venderAviao(Aviao aviaoVendido) {
        this.avioesDisponiveis.remove(aviaoVendido);
    }

    public void imprimirCatalogo() {
        System.out.println("\n\n*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* Catálogo de Aviões Disponíveis *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        for (Aviao aviaoAtual : this.avioesDisponiveis) {
            System.out.print("\n✈ ");
            aviaoAtual.exibirDetalhes();
        }
    }
}
