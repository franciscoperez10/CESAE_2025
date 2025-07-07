package Models;

/**
 * Representa a Venda de uma experiência
 * Inclui o tipo de cliente e a data (mês e ano)
 */

public class Venda {
    private String idVenda;
    private String idExperiencia;
    private String tipoCliente;
    private int ano;
    private int mes;

    public Venda(String idVenda, String idExperiencia, String tipoCliente, int ano, int mes) {
        this.idVenda = idVenda;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.ano = ano;
        this.mes = mes;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(String idExperiencia) {
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

    /**
     * Retorna os dados do Objeto Venda
     */
    @Override
    public String toString() {
        return "ID da Venda: " + idVenda +
                " | Experiência: " + idExperiencia +
                " | Tipo de Cliente: " + tipoCliente +
                " | Ano: " + ano +
                " | Mês: " + mes;
    }
}
