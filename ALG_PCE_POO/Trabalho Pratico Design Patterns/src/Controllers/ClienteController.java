package Controllers;

import Models.Experiencia;
import Models.Quarto;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClienteController {

    private RepoClientes repoClientes;
    private RepoExperiências repoExperiências;
    private RepoGuiaExperiencia repoGuiaExperiencia;
    private RepoQuartos repoQuartos;
    private RepoRating repoRating;
    private RepoTipologia repoTipologia;
    private RepoUtilizador repoUtilizador;
    private RepoVendas repoVendas;

    public ClienteController() throws FileNotFoundException {
        this.repoClientes = repoClientes;
        this.repoExperiências = repoExperiências;
        this.repoGuiaExperiencia = repoGuiaExperiencia;
        this.repoQuartos = repoQuartos;
        this.repoRating = repoRating;
        this.repoTipologia = repoTipologia;
        this.repoUtilizador = repoUtilizador;
        this.repoVendas = repoVendas;
    }

    public void mostrarListaQuartosDisponiveis() {
        System.out.println("Quartos Disponíveis: ");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void mostrarListaExperienciasDisponiveis(ArrayList<Experiencia> experiencias) {
        System.out.println("Experiências Disponíveis: ");
        for (Experiencia experiencia : experiencias) {
            System.out.println(experiencia);
        }
    }

    public void mostrarExperienciasFavoritas() {

    }

    public void mostrarExperienciasTopSeller() {

    }

    public void avaliarExperiencia() {

    }
}
