package Models;

/**
 * Representa a Tipologia de um Quarto
 * Tem a descrição e o preço por semana
 */

public class Tipologia {
    private int idTipologia;
    private String descricao;
    private double precoPorSemana;

    public Tipologia(int idTipologia, String descricao, double precoPorSemana) {
        this.idTipologia = idTipologia;
        this.descricao = descricao;
        this.precoPorSemana = precoPorSemana;
    }

    public int getIdTipologia() {
        return idTipologia;
    }

    public void setIdTipologia(int idTipologia) {
        this.idTipologia = idTipologia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoPorSemana() {
        return precoPorSemana;
    }

    public void setPrecoPorSemana(double precoPorSemana) {
        this.precoPorSemana = precoPorSemana;
    }

    @Override
    public String toString() {
        return "Tipologia: " + descricao +
                " | ID: " + idTipologia +
                " | Preço por Semana: " + precoPorSemana;
    }
}
