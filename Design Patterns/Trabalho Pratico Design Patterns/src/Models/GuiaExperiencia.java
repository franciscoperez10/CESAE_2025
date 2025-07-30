package Models;

public class GuiaExperiencia {
    private String id;
    private String nome;
    private String nacionalidade;
    private String email;
    private String telemovel;

    public GuiaExperiencia(String id, String nome, String nacionalidade, String email, String telemovel) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    /**
     * Retorna os dados do Objeto Guia Experiência
     */
    @Override
    public String toString() {
        return "Guia: " + nome +
                " | ID: " + id +
                " | Nacionalidade " + nacionalidade +
                " | Email " + email +
                " | Telemóvel: " + telemovel;
    }
}

