package Controllers;

import Models.Utilizador;
import Repositories.RepoUtilizador;

import java.io.FileNotFoundException;

/**
 * Controlador responsável pela autenticação dos utilizadores do sistema
 */
public class LoginController {

    private RepoUtilizador repoUtilizador;

    /**
     * Inicia o repositório de utilizadores
     *
     * @throws FileNotFoundException
     */
    public LoginController() throws FileNotFoundException {
        this.repoUtilizador = new RepoUtilizador();
    }


    /**
     * Método que valida o login de um utilizador
     *
     * @param usernameInput
     * @param passwordInput
     * @return "ADMIN", "GUIA", "GESTAO" ou "ERROR"
     */
    public String validateLogin(String usernameInput, String passwordInput) {
        // Percorre os utilizadores registados
        for (Utilizador utilizadorAtual : this.repoUtilizador.getUtilizadorArray()) {
            // Valida se o username e password coincidem com o input do utilizador
            if (utilizadorAtual.getUsername().equals(usernameInput) && utilizadorAtual.getPassword().equals(passwordInput)) {

                // Se coincidir, retorna o tipo de utilizador específico
                return utilizadorAtual.getTipoUtilizador();
            }


        }
        // Se não coincidir, devolve a mensagem de erro
        return "ERROR";
    }
}
