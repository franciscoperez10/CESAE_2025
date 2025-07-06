package Models;

public class Utilizador {
    private String tipoUtilizador;
    private String username;
    private String password;

    public Utilizador(String tipoUtilizador, String username, String password) {
        this.tipoUtilizador = tipoUtilizador;
        this.username = username;
        this.password = password;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
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
}
