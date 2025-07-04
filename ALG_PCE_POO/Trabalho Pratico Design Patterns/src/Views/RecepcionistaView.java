package Views;

import Controllers.AdminController;
import Controllers.RecepcionistaController;
import Models.Quarto;

import java.util.ArrayList;
import java.util.Scanner;

public class RecepcionistaView {

    private RecepcionistaController recepcionistaController;

    public RecepcionistaView() {
        this.recepcionistaController = new RecepcionistaController();
    }

    public void recepcionistaMenu () {
        Scanner input = new Scanner(System.in);
        int opcaoRecepcionista;
    }

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
