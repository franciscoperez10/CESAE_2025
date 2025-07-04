package Controllers;

import Repositories.*;
import Views.AdminView;

import java.io.FileNotFoundException;

public class AdminController {
    private RepoClientes repoClientes;
    private RepoExperiências repoExperiências;
    private RepoGuiaExperiencia repoGuiaExperiencia;
    private RepoQuartos repoQuartos;
    private RepoRating repoRating;
    private RepoReservas repoReservas;
    private RepoTipologia repoTipologia;
    private RepoVendas repoVendas;

    public AdminController () throws FileNotFoundException {
        this.repoClientes = repoClientes;
        this.repoExperiências = repoExperiências;
        this.repoGuiaExperiencia = repoGuiaExperiencia;
        this.repoQuartos = repoQuartos;
        this.repoRating = repoRating;
        this.repoReservas = repoReservas;
        this.repoTipologia = repoTipologia;
        this.repoVendas = repoVendas;
    }

    public void mostrarTotalReservas() {

    }

    public void mostrarTotalReceitas() {

    }

    public void mostrarReservasEReceitasMensais() {

    }

    public void mostrarTipologiaMaisReservada() {

    }

    public void mostrarExperienciaMaisProcuradaAdultos() {

    }

    public void mostrarExperienciaMaisProcuradaCriancas() {

    }

    public void mostrarExperienciaMaisLucrativa() {

    }

    public void mostrarExperienciaMenosLucrativa() {

    }

    public void mostrarQuartoComMelhorPrecoPorSemana() {

    }

    public void adicionarNovoLogin() {
    }
}
