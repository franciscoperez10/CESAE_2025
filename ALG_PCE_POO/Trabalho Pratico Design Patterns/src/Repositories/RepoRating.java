package Repositories;

import Models.Rating;
import Tools.HotelFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepoRating {
    private ArrayList<Rating> ratingsArray;

    public RepoRating() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.ratingsArray = csvFR.ratingFileReader("Files/ratings_experiencias.csv");
    }

    public ArrayList<Rating> getRatingsArray() {
        return ratingsArray;
    }
}
