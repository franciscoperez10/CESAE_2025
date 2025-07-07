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
    // Repositórios de acesso aos dados de experiências e vendas
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

        // Percorre as experiências que estão registadas
        for (Experiencia experiencia : repoExperiências.getExperiênciasArray()) {
            // Valida se a experiência pertence ao guia respetivo
            if (experiencia.getId_guia_experiencia().equals(idGuia)) {
                // Começam a 0.0 porque vão acumular os valores
                int totalAdultosInscritos = 0;
                int totalCriancasInscritas = 0;
                double totalArrecadado = 0.0;

                // Percorre todas as vendas para esta experiência
                for (Venda venda : repoVendas.getVendasArray()) {
                    // Faz a contagem de bilhetes de adulto e soma o respetivo preço
                    if (venda.getIdExperiencia().equals(experiencia.getIdExperiencia())) {
                        if (venda.getTipoCliente().equalsIgnoreCase("adulto")) {
                            totalAdultosInscritos++;
                            totalArrecadado += experiencia.getPreco_adulto();
                        }
                        // Faz a contagem de bilhetes de criança e soma o respetivo preço
                        if (venda.getTipoCliente().equalsIgnoreCase("crianca")) {
                            totalCriancasInscritas++;
                            totalArrecadado += experiencia.getPreco_crianca();
                        }
                    }
                }

                // Adiciona o resultado total
                resultado.add(
                        experiencia.getNome() + " | " + experiencia.getIdExperiencia() +
                                " | Bilhetes de Adulto: " + totalAdultosInscritos +
                                " | Bilhetes de Criança: " + totalCriancasInscritas +
                                // Arredonda o total arrecadado, e mostra o valor em Euros, ou seja, formato monetário
                                // Multiplica o total por 100, para que possa mover duas casas decimais para a esquerda
                                // Arredonda para o Inteiro mais próximo
                                // Divide por 100 para colocar a separação decimal corretamente
                                " | Total de Vendas: " + Math.round(totalArrecadado * 100.0) / 100.0 + " €"
                );
            }
        }
        // Retorna a lista
        return resultado;
    }
}
