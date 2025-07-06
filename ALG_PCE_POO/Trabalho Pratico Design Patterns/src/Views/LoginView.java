package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void mainMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcaoLogin;

        do {
            System.out.println("\n\n********** Bem-vindo/a ao Programa do CESAE Resort - Hotel Temático da Programação **********\n");
            System.out.println("1. Cliente");
            System.out.println("2. Staff");
            System.out.println("\n0. Terminar Programa");

            System.out.print("\nOpção: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {
                case 1:
                    // CLIENTE
                    ClienteView cv = new ClienteView();
                    cv.clienteMenu();
                    break;

                case 2:
                    // MEMBRO DA EQUIPA
                    this.loginMenu();
                    break;

                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }


    public void loginMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String username = input.next();

        System.out.print("Password: ");
        String password = input.next();

        String accessType = this.loginController.validateLogin(username, password);

        switch (accessType) {
            case "ADMIN":
                AdminView av = new AdminView();
                av.adminMenu();
                break;

            case "GUIA":
                GuiaView gv = new GuiaView();
                gv.guiaMenu(username);

            case "RECEP":
                RecepcionistaView rv = new RecepcionistaView();
                rv.recepcionistaMenu();
                break;

            case "ERROR":
                System.out.println("Acessos inválidos");
                break;
        }

    }


}
