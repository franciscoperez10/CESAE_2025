package Models;

public class Venda {
    private int idVenda;
    private int idExperiencia;
    private String tipoCliente;
    private int ano;
    private int mes;

    public Venda(int idVenda, int idExperiencia, String tipoCliente, int ano, int mes) {
        this.idVenda = idVenda;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.ano = ano;
        this.mes = mes;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
