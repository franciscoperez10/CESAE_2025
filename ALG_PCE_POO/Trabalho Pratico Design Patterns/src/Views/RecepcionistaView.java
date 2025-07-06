package Views;

import Controllers.RecepcionistaController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vista responsável pela interação com o recepcionista
 */
public class RecepcionistaView {

    private RecepcionistaController recepcionistaController;
    private final Scanner input;

    /**
     * Inicia o controlador
     * @param input
     * @throws FileNotFoundException
     */
    public RecepcionistaView(Scanner input) throws FileNotFoundException {
        this.recepcionistaController = new RecepcionistaController();
        this.input = input;
    }

    /**
     * Inicia o menu principal do recepcionista
     */
    public void recepcionistaMenu () {
        menuPrincipal();
    }

    /**
     * Exibe o menu principal do recepcionista e mostra as opções disponíveis
     */
    public void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcaoRecepcionista;

        do {
            System.out.println("***** Menu de Recepcionista *****");
            System.out.println("\nSeleccione a opção que deseja: ");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção");
            opcaoRecepcionista = input.nextInt();

            switch (opcaoRecepcionista) {
                case 1:
                    recepcionistaController.mostrarListaQuartosDisponiveis();
                    break;
                case 2:
                    recepcionistaController.mostrarQuartosReservados();
                    break;
                case 3:
                    recepcionistaController.mostrarReservasAtuais();
                    break;
                case 4:
                    recepcionistaController.efetuarReservas();
                    break;
                case 5:
                    recepcionistaController.reservarExperiencias();
                    break;
                case 0:
                    System.out.println("A sair do menu de administrador.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");


            }
        } while (opcaoRecepcionista != 0);


    }
}
