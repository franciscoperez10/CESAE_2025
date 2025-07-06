package Repositories;

import Models.Cliente;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RepoClientes {
    private ArrayList<Cliente> clientesArray;

    public RepoClientes() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.clientesArray = csvFR.clienteFileReader("Files/clientes.csv");
    }

    public ArrayList<Cliente> getClientesArray() {
        return clientesArray;
    }
}
