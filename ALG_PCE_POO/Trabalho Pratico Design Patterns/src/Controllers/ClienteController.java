package Controllers;

import Models.Experiencia;
import Models.Quarto;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades do cliente
 * Permite consultar quartos, experiências, bem como avaliá-las
 */
public class ClienteController {

    private RepoClientes repoClientes;
    private RepoExperiências repoExperiências;
    private RepoGuiaExperiencia repoGuiaExperiencia;
    private RepoQuartos repoQuartos;
    private RepoRating repoRating;
    private RepoTipologia repoTipologia;
    private RepoUtilizador repoUtilizador;
    private RepoVendas repoVendas;

    /**
     * Inicia os repositórios necessários para as operações do cliente
     * @throws FileNotFoundException
     */
    public ClienteController() throws FileNotFoundException {
        this.repoClientes = new RepoClientes();
        this.repoExperiências = new RepoExperiências();
        this.repoGuiaExperiencia = new RepoGuiaExperiencia();
        this.repoQuartos = new RepoQuartos();
        this.repoRating = new RepoRating();
        this.repoTipologia = new RepoTipologia();
        this.repoUtilizador = new RepoUtilizador();
        this.repoVendas = new RepoVendas();
    }

    public void mostrarListaQuartosDisponiveis() {
        ArrayList<Quarto> quartos = repoQuartos.getQuartosArray();
        System.out.println("Quartos Disponíveis: ");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void mostrarListaExperienciasDisponiveis() {
        ArrayList<Experiencia> experiencias = repoExperiências.getExperiênciasArray();
        System.out.println("Experiências Disponíveis: ");
        for (Experiencia experiencia : experiencias) {
            System.out.println(experiencia);
        }
    }

    public void mostrarExperienciasFavoritas() {

    }

    /**
     * Retorna a lista de experiências top seller.
     * @return Lista de experiências top seller.
     */
    public void mostrarExperienciasTopSeller() {

    }

    /**
     * Regista uma avaliação de uma experiência.
     */
    public void avaliarExperiencia() {

    }
}
