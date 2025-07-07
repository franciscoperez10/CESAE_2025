package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vista responsável pela interação inicial e login dos utilizadores
 */
public class LoginView {

    private final Scanner input;
    private LoginController loginController;

    /**
     * Inicia o controlador
     *
     * @throws FileNotFoundException
     */
    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
        this.input = new Scanner(System.in);
    }

    /**
     * Método que apresenta o menu principal do programa
     *
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
                    // Entra no menu principal do cliente
                    ClienteView cv = new ClienteView();
                    cv.menuPrincipal();
                    break;

                case 2:
                    // Entra no menu de staff que, depois, encaminha para o Admin, Guia ou Recepcionista
                    this.loginMenu();
                    break;
                // Mensagem que surge quando se sai do programa
                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;
                // Mensagem de erro, em caso de selecão de opções inválidas
                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }


    /**
     * Método que processa o login do Staff
     * Separa por menu correspodente
     *
     * @throws FileNotFoundException
     */
    public void loginMenu() throws FileNotFoundException {
        // Pede os dados de acesso ao utilizador
        System.out.print("\nUsername: ");
        String username = this.input.next();

        System.out.print("Password: ");
        String password = this.input.next();

        String accessType = this.loginController.validateLogin(username, password);

        // Direcciona para o tipo de utilizador
        switch (accessType) {
            // Menu de Administrador
            case "ADMIN":
                AdminView av = new AdminView();
                av.menuPrincipal();
                break;
            // Menu de Guia de Experiência
            case "GUIA":
                GuiaView gv = new GuiaView();
                gv.guiaMenu(username);
                break;
            // Menu de Gestão
            case "GESTAO":
                RecepcionistaView rv = new RecepcionistaView(input);
                rv.menuPrincipal();
                break;
            // Mensagem de erro, em caso de credenciais inválidos
            case "ERROR":
                System.out.println("Acessos inválidos");
                break;
        }

    }


}
