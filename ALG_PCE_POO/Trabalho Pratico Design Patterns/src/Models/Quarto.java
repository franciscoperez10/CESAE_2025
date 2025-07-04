package Models;

public class Quarto {
    private int num_quarto;
    private int id_tipologia;
    private double precoPorSemana;
    private boolean disponivel;

    public Quarto(int num_quarto, int id_tipologia, double precoPorSemana, boolean disponivel) {
        this.num_quarto = num_quarto;
        this.id_tipologia = id_tipologia;
        this.precoPorSemana = precoPorSemana;
        this.disponivel = disponivel;
    }

    public int getNum_quarto() {
        return num_quarto;
    }

    public void setNum_quarto(int num_quarto) {
        this.num_quarto = num_quarto;
    }

    public int getId_tipologia() {
        return id_tipologia;
    }

    public void setId_tipologia(int id_tipologia) {
        this.id_tipologia = id_tipologia;
    }

    public double getPrecoPorSemana() {
        return precoPorSemana;
    }

    public void setPrecoPorSemana(double precoPorSemana) {
        this.precoPorSemana = precoPorSemana;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
