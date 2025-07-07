package Repositories;

import Models.GuiaExperiencia;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável por fornecer a lista de guias de experiências
 */
public class RepoGuiaExperiencia {
    // Lista de Guias de Experiências carregadas a partir do CSV
    private ArrayList<GuiaExperiencia> guiaExperienciasArray;

    /**
     * Lê os guias do ficheiro CSV
     *
     * @throws FileNotFoundException
     */
    public RepoGuiaExperiencia() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.guiaExperienciasArray = csvFR.guiaExperienciaFileReader("Files/guias_experiencias.csv");

    }

    /**
     * Retorna a lista de guias de experiência
     * @return a lista de guias de experiência
     */
    public ArrayList<GuiaExperiencia> getGuiaExperienciasArray() {
        return guiaExperienciasArray;
    }
}
