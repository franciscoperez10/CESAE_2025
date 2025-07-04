package Controllers;

import Models.Utilizador;
import Repositories.RepoUtilizador;

import java.io.FileNotFoundException;

public class LoginController {

    private RepoUtilizador repoUtilizador;

    public LoginController() throws FileNotFoundException {
        this.repoUtilizador = new RepoUtilizador();
    }


    public String validateLogin(String usernameInput, String passwordInput) {
        for(Utilizador utilizadorAtual: this.repoUtilizador.getUtilizadorArray()){
            if(utilizadorAtual.getUsername().equals(usernameInput) && utilizadorAtual.getPassword().equals(passwordInput)){

                return utilizadorAtual.getTipoUtilizador();
            }


        }
        return "ERROR";
    }
}
