package Ex03;

import Ex03.Enums.UnidadeDeMedida;

public class Ingrediente {
    private int codigo;
    private String nome;
    private UnidadeDeMedida unidadeDeMedida;
    private int numKcal;

    public Ingrediente(int codigo, String nome, UnidadeDeMedida unidadeDeMedida, int numKcal) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidadeDeMedida = unidadeDeMedida;
        this.numKcal = numKcal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public int getNumKcal() {
        return numKcal;
    }

    public void setNumKcal(int numKcal) {
        this.numKcal = numKcal;
    }
}
