package Views;

import Controllers.GuiaController;
import Models.Experiencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vista responsável pela interação com o guia da experiência
 * Exibe menus e recolhe opções do utilizador
 */
public class GuiaView {

    private GuiaController guiaController;

    /**
     * Inicia o construtor
     * @throws FileNotFoundException
     */
    public GuiaView() throws FileNotFoundException {
        this.guiaController = new GuiaController();
    }

    /**
     * Inicia o menu principal do guia
     * @param username
     */
    public void guiaMenu(String username) {
        Scanner input = new Scanner(System.in);
        int opcaoGuia;


        do {
            System.out.println("***** Menu de Guia *****");
            System.out.println("1.Consultar Histórico de Experiências");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcaoGuia = input.nextInt();

            switch (opcaoGuia) {
                case 1:
                    guiaController.consultarHistoricoExperiencias(username);
                    break;
                case 0:
                    System.out.println("A sair do menu de guia.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");


            }

        } while (opcaoGuia != 0);


    }

    /**
     * Mostra o histórico de experiências do guia.
     * @param id ID do guia autenticado.
     */
    public void mostrarHistoricoExperiencias(String id) {
        ArrayList<String> linhas = guiaController.consultarHistoricoExperiencias(id);
            System.out.println("Histórico de Experiências: ");
        if (linhas.size() == 0) {
            System.out.println("Não existem experiências associadas a este guia.");
        } else {
            for (String linha : linhas) {
                System.out.println(linha);
            }
        }
    }


}
