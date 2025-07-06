package Repositories;

import Models.Utilizador;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável por carregar e fornecer a lista de utilizadores do sistema.
 */
public class RepoUtilizador {

    private ArrayList<Utilizador> utilizadorArray;

    /**
     * Lê os utilizadores do ficheiro CSV
     * @throws FileNotFoundException
     */
    public RepoUtilizador() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.utilizadorArray = csvFR.utilizadorFileReader("Files/logins.csv");

    }

    /**
     * Retorna a lista de utilizadores
     * @return a lista de utilizadores
     */
    public ArrayList<Utilizador> getUtilizadorArray() {
        return utilizadorArray;
    }

}