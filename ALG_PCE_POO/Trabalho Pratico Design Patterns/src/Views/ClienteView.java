package Views;

import Controllers.ClienteController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClienteView {
    private ClienteController clienteController;

    public ClienteView() throws FileNotFoundException {
        this.clienteController = new ClienteController();
    }

    public void clienteMenu() {
        Scanner input = new Scanner(System.in);
        int opcaoCliente;
    }

    public void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {
            System.out.println("***** Menu de Cliente *****");
            System.out.println("\nSeleccione a opção que deseja: ");
            System.out.println("1. Consulte os Quartos Disponíveis");
            System.out.println("2. Consulte as Experiências");
            System.out.println("3. Fazer uma Reserva");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção");
            opcaoCliente = input.nextInt();

            switch (opcaoCliente) {
                case 1:
                    System.out.println(clienteController.mostrarListaQuartosDisponiveis();
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
