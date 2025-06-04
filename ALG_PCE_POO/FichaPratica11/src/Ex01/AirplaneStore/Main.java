package Ex01.AirplaneStore;

import Ex01.Avioes.AviaoCombate;
import Ex01.Avioes.JatoPrivado;
import Ex01.Enums.Arma;
import Ex01.Enums.CategoriaJato;
import Ex01.Enums.InstalacaoJato;

public class Main {
    public static void main(String[] args) {

        JatoPrivado blackPanther = new JatoPrivado(1200, "Black Panther", 2025, 4000, 100, 5, 3, 4, 15000, 950, 130000,555, CategoriaJato.LIGHT_JET);
        blackPanther.adicionarInstalacao(InstalacaoJato.WC);
        blackPanther.adicionarInstalacao(InstalacaoJato.WIFI);
        blackPanther.adicionarInstalacao(InstalacaoJato.SUITE);

        JatoPrivado superMan = new JatoPrivado(1300, "Super Man", 2023, 5000, 120, 6, 5, 6, 18000, 1040, 190000, CategoriaJato.MIDSIZE_JET);
        superMan.adicionarInstalacao(InstalacaoJato.CHUVEIRO);
        superMan.adicionarInstalacao(InstalacaoJato.CINEMA);
        superMan.adicionarInstalacao(InstalacaoJato.ESCRITORIO);

        AviaoCombate stormTrooper = new AviaoCombate(2000, "Storm Trooper", 1981, 9000, 235, 10, 8, 4, 15000, 750, 210000, CategoriaJato.HEAVY_JET);
        stormTrooper.adicionarArma(Arma.BOMBAS);
        stormTrooper.adicionarArma(Arma.FOGUETES);
        stormTrooper.adicionarArma(Arma.METRALHADORAS);

        AviaoCombate deathStar = new AviaoCombate(7600, "Death Star", 1984, 5000, 150, 8, 2, 8, 20000, 900, 35000, CategoriaJato.HEAVY_JET);
        deathStar.adicionarArma(Arma.METRALHADORAS);
        deathStar.adicionarArma(Arma.FOGUETES);
        deathStar.adicionarArma(Arma.TORPEDOS);

        Catalogo ct = new Catalogo();

        ct.adquirirAviao(blackPanther);
        ct.adquirirAviao(superMan);
        ct.adquirirAviao(stormTrooper);
        ct.adquirirAviao(deathStar);

        ct.imprimirCatalogo();


    }

}
