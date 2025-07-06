package Views;

import Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vista responsável pela interação do utilizador Administrador
 */
public class AdminView {

    private AdminController adminController;
    private Scanner input = new Scanner(System.in);

    /**
     * Inicia o controlador
     * @throws FileNotFoundException
     */
    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    /**
     * Inicia o menu principal do administrador.
     */
    public void adminMenu() {
        menuPrincipal();
    }

    /**
     * Apresenta o menu principal do administrador e retrata as opções escolhidas.
     */
    public void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcaoAdmin;

        do {
            System.out.println("***** Menu de Administrador *****");
            System.out.println("\nSeleccione a opção que deseja: ");
            System.out.println("1. Consultar Total de Reservas");
            System.out.println("2. Consultar Total de Receitas");
            System.out.println("3. Consultar Reservas/Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos) – Número de bilhetes vendidos");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças) – Número de bilhetes vendidos");
            System.out.println("7. Consultar Experiência Mais Lucrativa – Valor total arrecadado");
            System.out.println("8. Consultar Experiência Menos Lucrativa – Valor total arrecadado");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana");
            System.out.println("10. Adicionar Novo Login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoAdmin = input.nextInt();

            switch (opcaoAdmin) {
                case 1:
                    int total = adminController.mostrarTotalReservas();
                    System.out.println("Total de Reservas: " + total);
                    break;
                case 2:
                    double receitas = adminController.mostrarTotalReceitas();
                    System.out.println("Total de Receitas: " + receitas + " €");
                    break;
                case 3:
                    adminController.mostrarReservasEReceitasMensais();
                    break;
                case 4:
                    adminController.mostrarTipologiaMaisReservada();
                    break;
                case 5:
                    adminController.mostrarExperienciaMaisProcuradaAdultos();
                    break;
                case 6:
                    adminController.mostrarExperienciaMaisProcuradaCriancas();
                    break;
                case 7:
                    adminController.mostrarExperienciaMaisLucrativa();
                    break;
                case 8:
                    adminController.mostrarExperienciaMenosLucrativa();
                    break;
                case 9:
                    adminController.mostrarQuartoComMelhorPrecoPorSemana();
                    break;
                case 10:
                    adminController.adicionarNovoLogin();
                    break;
                case 0:
                    System.out.println("A sair do menu de administrador.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoAdmin != 0);
    }


}
