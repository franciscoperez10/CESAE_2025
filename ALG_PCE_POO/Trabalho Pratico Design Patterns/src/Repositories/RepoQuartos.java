package Repositories;

import Models.Quarto;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RepoQuartos {
    private ArrayList<Quarto> quartosArray;

    public RepoQuartos() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.quartosArray = csvFR.quartoFileReader("Files/quartos.csv");
    }

    public ArrayList<Quarto> getQuartosArray() {
        return quartosArray;
    }
}
