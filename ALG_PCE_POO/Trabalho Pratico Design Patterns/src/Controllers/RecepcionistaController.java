package Controllers;

import Models.Quarto;
import Models.Reserva;
import Repositories.RepoQuartos;
import Repositories.RepoReservas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades do menu do recepcionista
 * Permite ver os quartos, reservas e fazer operações
 */
public class RecepcionistaController {
    private RepoQuartos repoQuartos;
    private RepoReservas repoReservas;

    /**
     * Inicia os repositórios necessários
     * @throws FileNotFoundException
     */
    public RecepcionistaController() throws FileNotFoundException {
        this.repoQuartos = new RepoQuartos();
        this.repoReservas = new RepoReservas();
    }

    /**
     * Retorna a lista de quartos disponíveis.
     * @return Lista de quartos disponíveis.
     */
    public ArrayList<Quarto> mostrarListaQuartosDisponiveis() {
        return repoQuartos.getQuartosArray();

    }

    /**
     * Retorna a lista de quartos reservados.
     * @return Lista de quartos reservados.
     */
    public void mostrarQuartosReservados() {

    }

    /**
     * Retorna a lista de reservas atuais.
     * @return Lista de reservas atuais.
     */
    public void mostrarReservasAtuais() {
        ArrayList<Reserva> reservas = repoReservas.getReservasArray();
        System.out.println("Reservas Atuais: ");
        for (Reserva reserva: reservas) {
            System.out.println(reserva);
        }

    }

    /**
     * Permite efetuar novas reservas
     */
    public void efetuarReservas() {

    }

    /**
     * Permite reservas experiências
     */
    public void reservarExperiencias() {

    }
}
