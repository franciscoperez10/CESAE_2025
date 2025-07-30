package GrandesNegocios.Models;

public class User {
    private String tipoConta;
    private String username;
    private String passoword;

    public User(String tipoConta, String username, String passoword) {
        this.tipoConta = tipoConta;
        this.username = username;
        this.passoword = passoword;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getUsername() {
        return username;
    }

    public String getPassoword() {
        return passoword;
    }
}
