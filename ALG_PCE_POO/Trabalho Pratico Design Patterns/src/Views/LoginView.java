package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;
    private final Scanner input;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
        this.input = new Scanner(System.in);
    }

    public void mainMenu() throws FileNotFoundException {

        int opcaoLogin;

        do {
            System.out.println("\n\n********** Bem-vindo/a ao Programa do CESAE Resort - Hotel Temático da Programação **********\n");
            System.out.println("1. Cliente");
            System.out.println("2. Staff");
            System.out.println("0. Terminar Programa");

            System.out.print("\nOpção: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {
                case 1:

                    ClienteView cv = new ClienteView();
                    cv.menuPrincipal();
                    break;

                case 2:

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
                av.menuPrincipal();
                break;

            case "GUIA":
                GuiaView gv = new GuiaView();
                gv.guiaMenu(username);
                break;

            case "RECEP":
                RecepcionistaView rv = new RecepcionistaView(input);
                rv.menuPrincipal();
                break;

            case "ERROR":
                System.out.println("Acessos inválidos");
                break;
        }

    }


}
