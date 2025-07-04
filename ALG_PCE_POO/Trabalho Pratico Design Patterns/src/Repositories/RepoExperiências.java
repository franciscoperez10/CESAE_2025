package Repositories;

import Models.Experiencia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RepoExperiências {
    private ArrayList<Experiencia> experienciasArray;

    public RepoExperiências() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.experienciasArray = csvFR.experienciaFileReader("Files/experiencias.csv");
    }

    public ArrayList<Experiencia> getExperiênciasArray() {
        return experienciasArray;
    }
}
