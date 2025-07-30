package Repositories;

import Models.Reserva;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Repositório que carrega e fornece a lista de Reservas de Quartos
 */
public class RepoReservas {
    // Lista de Reservas carregada através do CSV
    private ArrayList<Reserva> reservasArray;

    /**
     * Lê as reservas do ficheiro CSV
     * @throws FileNotFoundException
     */
    public RepoReservas() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.reservasArray = csvFR.reservaFileReader("Files/reservas_quartos.csv");


    }

    /**
     * Retorna a lista de reservas
     * @return a lista de reservas
     */
    public ArrayList<Reserva> getReservasArray() {
        return reservasArray;
    }
}
