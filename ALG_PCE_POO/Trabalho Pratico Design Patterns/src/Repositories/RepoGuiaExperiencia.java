package Repositories;

import Models.GuiaExperiencia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepoGuiaExperiencia {
    private ArrayList<GuiaExperiencia> guiaExperienciasArray;

    public RepoGuiaExperiencia() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.guiaExperienciasArray = csvFR.guiaExperienciaFileReader("Files/guias_experiencias.csv");
    }
}
