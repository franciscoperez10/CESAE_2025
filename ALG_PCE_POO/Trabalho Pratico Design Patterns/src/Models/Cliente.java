package Models;

/**
 * Representa um cliente do Hotel, contendo os dados pedidos no enunciado
 */
public class Cliente {
    private String id;
    private String nome;
    private String nacionalidade;
    private String email;
    private String telemovel;
    private String dataNascimento;
    private boolean consentimentoMarketing;

    public Cliente(String id, String nome, String nacionalidade, String email, String telemovel, String dataNascimento, boolean consentimentoMarketing) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
        this.consentimentoMarketing = consentimentoMarketing;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isConsentimentoMarketing() {
        return consentimentoMarketing;
    }

    public void setConsentimentoMarketing(boolean consentimentoMarketing) {
        this.consentimentoMarketing = consentimentoMarketing;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
                " | ID: " + id +
                " | Nacionalidade: " + nacionalidade +
                " | Email: " + email +
                " | Telemóvel: " + telemovel +
                " | Nascimento " + dataNascimento +
                " | Consentimento de Marketing: " + consentimentoMarketing;
    }
}
