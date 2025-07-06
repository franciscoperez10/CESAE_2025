package Repositories;

import Models.Quarto;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Repositório que carrega a lista de Quartos do Hotel
 */
public class RepoQuartos {
    private ArrayList<Quarto> quartosArray;

    /**
     * Lê os Quartos do ficheiro CSV
     * @throws FileNotFoundException
     */
    public RepoQuartos() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.quartosArray = csvFR.quartoFileReader("Files/quartos.csv");
    }

    /**
     * Retorna a lista de Quartos
     * @return a lista de Quartos
     */
    public ArrayList<Quarto> getQuartosArray() {
        return quartosArray;
    }
}
