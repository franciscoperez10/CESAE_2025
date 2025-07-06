package Controllers;

import Models.Experiencia;
import Models.Venda;
import Repositories.RepoExperiências;
import Repositories.RepoVendas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades do guia de experiências
 * Permite consultar o histórico das experiências e estatísticas
 */
public class GuiaController {
    private RepoExperiências repoExperiências;
    private RepoVendas repoVendas;

    /**
     * Inicia os repositórios necessários
     * @throws FileNotFoundException
     */
    public GuiaController() throws FileNotFoundException {
        this.repoExperiências = new RepoExperiências();
        this.repoVendas = new RepoVendas();
    }

    /**
     * Consulta o histórico de experiências associadas a um guia.
     * Para cada experiência, apresenta o número de bilhetes vendidos e o total arrecadado.
     * @param idGuia ID do guia de experiência.
     * @return Lista de strings formatadas com o resumo de cada experiência.
     */
    public ArrayList<String> consultarHistoricoExperiencias(String idGuia) {
        ArrayList<String> resultado = new ArrayList<>();

        for (Experiencia experiencia : repoExperiências.getExperiênciasArray()) {
            if (experiencia.getId_guia_experiencia().equals(idGuia)) {
                int totalAdultosInscritos = 0;
                int totalCriancasInscritas = 0;
                double totalArrecadado = 0.0;

                for (Venda venda : repoVendas.getVendasArray()) {

                    if (venda.getIdExperiencia().equals(experiencia.getIdExperiencia())) {
                        if (venda.getTipoCliente().equalsIgnoreCase("adulto")) {
                            totalAdultosInscritos++;
                            totalArrecadado += experiencia.getPreco_adulto();
                        }
                        if (venda.getTipoCliente().equalsIgnoreCase("crianca")) {
                            totalCriancasInscritas++;
                            totalArrecadado += experiencia.getPreco_crianca();
                        }
                    }
                }

                resultado.add(
                        experiencia.getNome() + " | " + experiencia.getIdExperiencia() +
                                " | Bilhetes de Adulto: " + totalAdultosInscritos +
                                " | Bilhetes de Criança: " + totalCriancasInscritas +
                                " | Total de Vendas: " + Math.round(totalArrecadado * 100.0) / 100.0 + " €"
                );
            }
        }
        return resultado;
    }
}
