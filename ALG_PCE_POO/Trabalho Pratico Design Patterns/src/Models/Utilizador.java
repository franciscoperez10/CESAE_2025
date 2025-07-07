package Models;

/**
 * Representa um Utilizador que tem acesso ao sistema
 *
 */

public class Utilizador {

    private String username;
    private String password;
    private String tipoUtilizador;

    public Utilizador(String username, String password, String tipoUtilizador) {
        this.username = username;
        this.password = password;
        this.tipoUtilizador = tipoUtilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }

    /**
     * Retorna os dados do Objeto Utilizador
     */
    @Override
    public String toString() {
        return "Utilizador: " + username +
                " | Tipo: " + tipoUtilizador;
    }
}




