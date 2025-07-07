package Controllers;

import Models.Quarto;
import Models.Reserva;
import Models.Tipologia;
import Repositories.RepoQuartos;
import Repositories.RepoReservas;
import Repositories.RepoTipologia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades do menu do recepcionista
 * Permite ver os quartos, reservas e fazer operações
 */
public class RecepcionistaController {
    // Repositórios que permitem aceder aos dados dos Quartos, Reservas e Tipologia
    private RepoQuartos repoQuartos;
    private RepoReservas repoReservas;
    private RepoTipologia repoTipologia;

    /**
     * Inicia os repositórios necessários
     *
     * @throws FileNotFoundException
     */
    public RecepcionistaController() throws FileNotFoundException {
        this.repoQuartos = new RepoQuartos();
        this.repoReservas = new RepoReservas();
        this.repoTipologia = new RepoTipologia();
    }

    /**
     * Retorna a lista de quartos disponíveis.
     *
     * @return Lista de quartos disponíveis.
     */

    public ArrayList<Quarto> mostrarListaQuartosDisponiveis() {
        ArrayList<Quarto> todosOsQuartos = repoQuartos.getQuartosArray();
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        ArrayList<Reserva> reservas = repoReservas.getReservasArray();
        ArrayList<Tipologia> tipologias = repoTipologia.getTipologiasArray();

        // Data definida no enunciado
        int anoAtual = 2025;
        int mesAtual = 7;
        int semanaAtual = 1;

        // Percorre os quartos para verificar se estão disponíveis
        for (Quarto quarto : todosOsQuartos) {
            boolean quartoDisponivel = true;
            // Verifica se existem reservas para o quarto, na semana anteriormente definida
            for (Reserva reserva : reservas) {
                if (reserva.getNum_quarto() == quarto.getNum_quarto() &&
                        reserva.getAnoReserva() == anoAtual &&
                        reserva.getMesReserva() == mesAtual &&
                        reserva.getSemanaReserva() == semanaAtual) {
                    // Se houver reservas para o quarto, então está indisponível, logo, false
                    quartoDisponivel = false;
                    break;
                }
            }
            // Se o quarto está disponível, adiciona à lista de disponíveis
            if (quartoDisponivel) {
                quartosDisponiveis.add(quarto);
            }
        }

        // Retorna a lista de quartos disponíveis
        return quartosDisponiveis;
    }

    /**
     * Retorna a lista de quartos reservados.
     *
     * @return Lista de quartos reservados.
     */
    public void mostrarQuartosReservados() {

    }

    /**
     * Retorna a lista de reservas atuais.
     *
     * @return Lista de reservas atuais.
     */
    public void mostrarReservasAtuais() {
        ArrayList<Reserva> reservas = repoReservas.getReservasArray();
        System.out.println("Reservas Atuais: ");
        for (Reserva reserva : reservas) {
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