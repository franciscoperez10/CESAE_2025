package Repositories;

import Models.Venda;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RepoVendas {
    private ArrayList<Venda> vendasArray;

    public RepoVendas() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.vendasArray = csvFR.vendaFileReader("Files/vendas_experiencias.csv");

    }

    public ArrayList<Venda> getVendasArray() {
        return vendasArray;
    }
}
