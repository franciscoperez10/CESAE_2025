import Views.LoginView;

import java.io.FileNotFoundException;

/**
 * Classe principal que corre o programa
 * Inicia a aplicação do Hotel
 * Apresenta o menu inicial do login
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Cria uma instância da vista de login
        LoginView lv = new LoginView();
        // Começa o menu
        lv.mainMenu();

    }
}
