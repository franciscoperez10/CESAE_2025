package Controllers;

import Repositories.*;

import java.io.FileNotFoundException;

/**
 * Controlador responsável pela administração do sistema
 * Tem acesso a vários parâmetros, como números, valores, receitas, dados de login, entre outros.
 */
public class AdminController {
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
     * @throws FileNotFoundException
     */
    public AdminController () throws FileNotFoundException {
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
     * @return o número total de reservas efetuadas
     */
    public int mostrarTotalReservas() {
        return repoReservas.getReservasArray().size();
    }


    /**
     * Calcula o valor total das receitas do hotel.
     * @return Valor total das receitas.
     */
    public double mostrarTotalReceitas() {
        return 0.0;

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
