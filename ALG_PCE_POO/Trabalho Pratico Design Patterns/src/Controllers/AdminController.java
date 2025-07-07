package Controllers;

import Models.Quarto;
import Models.Reserva;
import Models.Tipologia;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pela administração do sistema
 * Tem acesso a vários parâmetros, como números, valores, receitas, dados de login, entre outros.
 */
public class AdminController {
    // Repositórios para aceder ao sistema
    private RepoClientes repoClientes;
    private RepoExperiências repoExperiências;
    private RepoGuiaExperiencia repoGuiaExperiencia;
    private RepoQuartos repoQuartos;
    private RepoRating repoRating;
    private RepoReservas repoReservas;
    private RepoTipologia repoTipologia;
    private RepoVendas repoVendas;

    /**
     * Inicializa todos os repositórios necessários para as operações do administrador.
     *
     * @throws FileNotFoundException
     */
    public AdminController() throws FileNotFoundException {
        this.repoClientes = new RepoClientes();
        this.repoExperiências = new RepoExperiências();
        this.repoGuiaExperiencia = new RepoGuiaExperiencia();
        this.repoQuartos = new RepoQuartos();
        this.repoRating = new RepoRating();
        this.repoReservas = new RepoReservas();
        this.repoTipologia = new RepoTipologia();
        this.repoVendas = new RepoVendas();
    }

    /**
     * Retorna o número total de reservas efetuadas.
     *
     * @return o número total de reservas efetuadas
     */
    public int mostrarTotalReservas() {
        return repoReservas.getReservasArray().size();
    }


    /**
     * Calcula o valor total das receitas do hotel.
     *
     * @return Valor total das receitas.
     */
    public double mostrarTotalReceitas() {
        // Inicia a 0.0 para posteriormente somar os valores das receitas
        double totalReceitas = 0.0;
        ArrayList<Reserva> reservas = repoReservas.getReservasArray();
        ArrayList<Quarto> quartos = repoQuartos.getQuartosArray();
        ArrayList<Tipologia> tipologias = repoTipologia.getTipologiasArray();

        // Percorre cada reserva, procurando o quarto e a sua tipologia correspondente
        for (Reserva reserva : reservas) {
            Quarto quarto = null;
            for (Quarto quarto1 : quartos) {
                if (quarto1.getNum_quarto() == reserva.getNum_quarto()) {
                    quarto = quarto1;
                    break;
                }
            }
            if (quarto != null) {
                Tipologia tipologia = null;
                // Procura pela tipologia associada ao quarto encontrado
                for (Tipologia tipologia1 : tipologias) {
                    if (tipologia1.getIdTipologia() == quarto.getId_tipologia()) {
                        tipologia = tipologia1; // Guarda a tipologia
                        break; // Termina o ciclo quando encontra a correta
                    }
                }
                if (tipologia != null) {
                    // Junta o preço da tipologia ao total das receitas
                    totalReceitas += tipologia.getPrecoPorSemana();
                }
            }
        }
        // Após iterar sobre as reservas, retorna o valor total acumulado das receitas
        return totalReceitas;
    }


    /**
     * Mostra as reservas e receitas mensais.
     */
    public void mostrarReservasEReceitasMensais() {

    }

    /**
     * Mostra a tipologia de quarto mais reservada.
     */
    public void mostrarTipologiaMaisReservada() {

    }

    /**
     * Mostra a experiência mais procurada por adultos.
     */
    public void mostrarExperienciaMaisProcuradaAdultos() {

    }

    /**
     * Mostra a experiência mais procurada por crianças.
     */
    public void mostrarExperienciaMaisProcuradaCriancas() {

    }

    /**
     * Mostra a experiência mais lucrativa.
     */
    public void mostrarExperienciaMaisLucrativa() {

    }

    /**
     * Mostra a experiência menos lucrativa.
     */
    public void mostrarExperienciaMenosLucrativa() {

    }

    /**
     * Mostra o quarto com melhor preço por semana.
     */
    public void mostrarQuartoComMelhorPrecoPorSemana() {

    }

    /**
     * Permite adicionar um novo login ao sistema.
     */
    public void adicionarNovoLogin() {
    }
}
