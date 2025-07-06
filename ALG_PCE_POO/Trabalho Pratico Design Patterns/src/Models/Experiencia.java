package Models;

public class Experiencia {
    private String idExperiencia;
    private String nome;
    private String id_guia_experiencia;
    private double preco_adulto;
    private double preco_crianca;

    public Experiencia(String idExperiencia, String nome, String id_guia_experiencia, double preco_adulto, double preco_crianca) {
        this.idExperiencia = idExperiencia;
        this.nome = nome;
        this.id_guia_experiencia = id_guia_experiencia;
        this.preco_adulto = preco_adulto;
        this.preco_crianca = preco_crianca;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(String idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_guia_experiencia() {
        return id_guia_experiencia;
    }

    public void setId_guia_experiencia(String id_guia_experiencia) {
        this.id_guia_experiencia = id_guia_experiencia;
    }

    public double getPreco_adulto() {
        return preco_adulto;
    }

    public void setPreco_adulto(double preco_adulto) {
        this.preco_adulto = preco_adulto;
    }

    public double getPreco_crianca() {
        return preco_crianca;
    }

    public void setPreco_crianca(double preco_crianca) {
        this.preco_crianca = preco_crianca;
    }
}