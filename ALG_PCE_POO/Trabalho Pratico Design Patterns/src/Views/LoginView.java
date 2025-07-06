package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vista responsável pela interação inicial e login dos utilizadores
 */
public class LoginView {

    private LoginController loginController;
    private final Scanner input;

    /**
     * Inicia o controlador
     * @throws FileNotFoundException
     */
    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
        this.input = new Scanner(System.in);
    }

    /**
     * Método que apresenta o menu principal do programa
     * @throws FileNotFoundException
     */
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


    /**
     * Método que processa o login do Staff
     * Separa por menu correspodente
     * @throws FileNotFoundException
     */
    public void loginMenu() throws FileNotFoundException {

        System.out.print("\nUsername: ");
        String username = this.input.next();

        System.out.print("Password: ");
        String password = this.input.next();

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

            case "GESTAO":
                RecepcionistaView rv = new RecepcionistaView(input);
                rv.menuPrincipal();
                break;

            case "ERROR":
                System.out.println("Acessos inválidos");
                break;
        }

    }


}
