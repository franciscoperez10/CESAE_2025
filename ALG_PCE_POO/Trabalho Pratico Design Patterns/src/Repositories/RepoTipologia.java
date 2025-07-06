package Repositories;

import Models.Tipologia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepoTipologia {
    private ArrayList<Tipologia> tipologiasArray;

    public RepoTipologia() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.tipologiasArray = csvFR.tipologiaFileReader("Files/tipologia.csv");
    }

    public ArrayList<Tipologia> getTipologiasArray() {
        return tipologiasArray;
    }
}
