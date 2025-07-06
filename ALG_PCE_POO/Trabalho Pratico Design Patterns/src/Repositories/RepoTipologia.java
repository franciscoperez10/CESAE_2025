package Repositories;

import Models.Tipologia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável por carregar e fornecer a lista de tipologias de quartos.
 */
public class RepoTipologia {
    private ArrayList<Tipologia> tipologiasArray;

    /**
     * Lê as tipologias de Quartos do ficheiro CSV
     * @throws FileNotFoundException
     */
    public RepoTipologia() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.tipologiasArray = csvFR.tipologiaFileReader("Files/tipologia.csv");
    }

    /**
     * Retorna a lista de tipologias
     * @return Retorna a lista de tipologias
     */
    public ArrayList<Tipologia> getTipologiasArray() {
        return tipologiasArray;
    }
}
