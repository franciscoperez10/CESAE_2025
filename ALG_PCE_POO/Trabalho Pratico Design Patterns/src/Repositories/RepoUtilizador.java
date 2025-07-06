package Repositories;

import Models.Utilizador;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepoUtilizador {

    private ArrayList<Utilizador> utilizadorArray;

    public RepoUtilizador() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.utilizadorArray = csvFR.utilizadorFileReader("Files/logins.csv");

    }

    public ArrayList<Utilizador> getUtilizadorArray() {
        return utilizadorArray;
    }

}