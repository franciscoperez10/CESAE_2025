package Repositories;

import Models.Cliente;
import Tools.HotelFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório que cria e fornece a lista de clientes do Hotel
 */

public class RepoClientes {
    // Lista de clientes carregada através do ficheiro CSV
    private ArrayList<Cliente> clientesArray;

    /**
     * Lê os clientes do ficheiro CSV
     * @throws FileNotFoundException
     */

    public RepoClientes() throws FileNotFoundException {
        HotelFileReader csvFR = new HotelFileReader();
        this.clientesArray = csvFR.clienteFileReader("Files/clientes.csv");
    }

    /**
     * Retorna a lista de clientes
     * @return a lista de clientes
     */

    public ArrayList<Cliente> getClientesArray() {
        return clientesArray;
    }
}
