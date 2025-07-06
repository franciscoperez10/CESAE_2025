package Views;

import Controllers.ClienteController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vista responsável pela interação com o cliente
 * Apresenta menus e recebe opções do utilizador
 */
public class ClienteView {
    private ClienteController clienteController;

    /**
     * Inicia o controlador
     * @throws FileNotFoundException
     */
    public ClienteView() throws FileNotFoundException {
        this.clienteController = new ClienteController();
    }

    /**
     * Inicia o menu principal do cliente
     */
    public void clienteMenu() {
     menuPrincipal();
    }

    /**
     * Exibe o menu principal do cliente e mostra as opções possíveis
     */
    public void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {
            System.out.println("***** Menu de Cliente *****");
            System.out.println("\nSeleccione a opção que deseja: ");
            System.out.println("1. Consulte os Quartos Disponíveis:");
            System.out.println("2. Consulte as Experiências Disponíveis:");
            System.out.println("3. Consulte as Experiências Favoritas:");
            System.out.println("4. Consulte as Experiências Top Seller:");
            System.out.println("5. Avalie as Experiências");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção");
            opcaoCliente = input.nextInt();

            switch (opcaoCliente) {
                case 1:
                    clienteController.mostrarListaQuartosDisponiveis();
                    break;
                case 2:
                    clienteController.mostrarListaExperienciasDisponiveis();
                    break;
                case 3:
                    clienteController.mostrarExperienciasFavoritas();
                    break;
                case 4:
                    clienteController.mostrarExperienciasTopSeller();
                    break;
                case 5:
                    clienteController.avaliarExperiencia();
                    break;
                case 0:
                    System.out.println("A sair do menu de cliente");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoCliente != 0);


    }
}
