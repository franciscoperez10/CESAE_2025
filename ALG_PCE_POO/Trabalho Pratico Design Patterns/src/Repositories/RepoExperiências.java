package Repositories;

import Models.Experiencia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RepoExperiências {
    private ArrayList<Experiencia> experienciasArray;

    /**
     * Lê as experiências do ficheiro CSV
     * @throws FileNotFoundException
     */

    public RepoExperiências() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.experienciasArray = csvFR.experienciaFileReader("Files/experiencias.csv");
    }

    /**
     * Retorna a lista de experiências
     * @return a lista de experiências
     */
    public ArrayList<Experiencia> getExperiênciasArray() {
        return experienciasArray;
    }
}
