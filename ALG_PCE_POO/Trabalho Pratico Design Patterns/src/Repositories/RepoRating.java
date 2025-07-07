package Repositories;

import Models.Rating;
import Tools.HotelFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório que carrega e fornece as avaliações (Ratings) das experiências
 */
public class RepoRating {
    // Lista de Ratings carregada através do CSV
    private ArrayList<Rating> ratingsArray;

    /**
     * Lê as avaliações do ficheiro CSV
     * @throws FileNotFoundException
     */
    public RepoRating() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.ratingsArray = csvFR.ratingFileReader("Files/ratings_experiencias.csv");
    }

    /**
     * Retorna a lista de Ratings carregados
     * @return
     */
    public ArrayList<Rating> getRatingsArray() {
        return ratingsArray;
    }
}
