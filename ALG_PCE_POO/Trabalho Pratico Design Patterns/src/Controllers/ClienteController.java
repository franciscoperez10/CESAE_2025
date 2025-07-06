package Controllers;

import Models.Experiencia;
import Models.Quarto;
import Models.Rating;
import Models.Tipologia;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades do cliente
 * Permite consultar quartos disponíveis, experiências, bem como avaliá-las
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
     *
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

    /** ArrayList que vai gerar os quartos disponíveis para reserva
     * Filtra os que cumprem a condição acima
     * @return Lista de Quartos disponíveis
     */
    public ArrayList<Quarto> getListaQuartosDisponiveis() {
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : repoQuartos.getQuartosArray()) {
            if (quarto.isDisponivel()) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }

    /**
     * Lista de tipologias
     * @return
     */
    public ArrayList<Tipologia> getListaTipologias() {
        return repoTipologia.getTipologiasArray();
    }

    /**
     * Método que mostra a lista de quartos disponíveis no Hotel
     * Exibe as várias informações necessárias
     */
    public void mostrarListaQuartosDisponiveis() {
        ArrayList<Quarto> quartos = repoQuartos.getQuartosArray();
        ArrayList<Tipologia> tipologias = repoTipologia.getTipologiasArray();

        System.out.println("Quartos Disponíveis: ");

        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                Tipologia tipologia = gerarTipologia(quarto.getId_tipologia(), tipologias);
                if (tipologia != null) {
                    System.out.println("Num_Quarto: " + quarto.getNum_quarto() +
                            " | Tipologia: " + tipologia.getDescricao() +
                            " | Preço por semana: " + tipologia.getPrecoPorSemana());
                }
            }
        }
    }

    /**
     * Procura uma tipologia através do seu ID
     * Percorre a lista até a encontrar
     * @param idTipologia
     * @param tipologias
     * @return
     */
    private Tipologia gerarTipologia(int idTipologia, ArrayList<Tipologia> tipologias) {
        for (Tipologia tipologia : tipologias) {
            if (tipologia.getIdTipologia() == idTipologia) {
                return tipologia;
            }
        }
        return null;
    }

    /**
     * Exibe a lista de experiências disponíveis no Hotel
     */
    public void mostrarListaExperienciasDisponiveis() {
        ArrayList<Experiencia> experiencias = repoExperiências.getExperiênciasArray();
        System.out.println("Experiências Disponíveis: ");
        for (Experiencia experiencia : experiencias) {
            System.out.println(experiencia);
        }
    }

    /**
     * Analise e retorna a experiência com melhor classificação
     * Calcula a média (Rating) de cada experiência
     * @return
     */
    public ArrayList<Experiencia> mostrarExperienciasFavoritas() {
        ArrayList<Experiencia> todasExperiencias = repoExperiências.getExperiênciasArray();
        ArrayList<Rating> ratings = repoRating.getRatingsArray();
        ArrayList<Experiencia> experienciasFavoritas = new ArrayList<>();

        double melhorRating = 0.0;
        for (Experiencia experiencia : todasExperiencias) {
            double soma = 0.0;
            int contagem = 0;
            for (Rating rating : ratings) {
                if (rating.getId_experiencia().equals(experiencia.getIdExperiencia())) {
                    soma += rating.getRating_experiencia();
                    contagem++;
                }
            }
            if (contagem > 0) {
                double media = soma / contagem;
                if (media > melhorRating) {
                    melhorRating = media;
                }
            }
        }

        for (Experiencia experiencia : todasExperiencias) {
            double soma = 0.0;
            int contagem = 0;
            for (Rating rating : ratings) {
                if (rating.getId_experiencia().equals(experiencia.getIdExperiencia())) {
                    soma += rating.getRating_experiencia();
                    contagem++;
                }
            }
            if (contagem > 0) {
                double media = soma / contagem;
                if (media == melhorRating) {
                    experienciasFavoritas.add(experiencia);
                }
            }
        }

        return experienciasFavoritas;

    }

    /**
     * Retorna a lista de experiências top seller.
     *
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
