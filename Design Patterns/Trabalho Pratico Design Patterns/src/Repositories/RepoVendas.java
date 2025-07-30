package Repositories;

import Models.Venda;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Repositório responsável por carregar e fornecer a lista de vendas de experiências.
 */
public class RepoVendas {

    // Listas de vendas de experiências carregada a partir do CSV
    private ArrayList<Venda> vendasArray;

    /**
     * Lê as vendas do ficheiro CSV.
     *
     * @throws FileNotFoundException
     */
    public RepoVendas() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.vendasArray = csvFR.vendaFileReader("Files/vendas_experiencias.csv");

    }

    /**
     * Retorna a lista de vendas
     *
     * @return Retorna a lista de vendas
     */
    public ArrayList<Venda> getVendasArray() {
        return vendasArray;
    }
}
