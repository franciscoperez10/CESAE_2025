package Repositories;

import Models.Reserva;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RepoReservas {
    private ArrayList<Reserva> reservasArray;

    public RepoReservas() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.reservasArray = csvFR.reservaFileReader("Files/reservas_quartos.csv");


    }

    public ArrayList<Reserva> getReservasArray() {
        return reservasArray;
    }
}
