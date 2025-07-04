package Views;

import Controllers.GuiaController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuiaView {

    private GuiaController guiaController;

    public GuiaView() throws FileNotFoundException {
        this.guiaController = new GuiaController();
    }

    public void guiaMenu(String username) {
        Scanner input = new Scanner(System.in);
        int opcaoGuia;
    }

    public void menuPrincipal(String username) {
        Scanner input = new Scanner(System.in);
        int opcaoGuia;

        do {
            System.out.println("***** Menu de Guia *****");
            System.out.println("1.Consultar Histórico de Experiências");
            System.out.println("0. Sair");
            opcaoGuia = input.nextInt();

        } while (opcaoGuia != 0);


        switch (opcaoGuia) {
            case 1:
                guiaController.consultarHistoricoExperiencias();
            case 0:
                System.out.println("A sair do menu de administrador.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");


        }
    }


}
