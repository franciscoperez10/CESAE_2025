package Models;

public class Reserva {
    private int idReserva;
    private int num_quarto;
    private String idCliente;
    private int anoReserva;
    private int mesReserva;
    private int semanaReserva;

    public Reserva(int idReserva, int num_quarto, String idCliente, int anoReserva, int mesReserva, int semanaReserva) {
        this.idReserva = idReserva;
        this.num_quarto = num_quarto;
        this.idCliente = idCliente;
        this.anoReserva = anoReserva;
        this.mesReserva = mesReserva;
        this.semanaReserva = semanaReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getNum_quarto() {
        return num_quarto;
    }

    public void setNum_quarto(int num_quarto) {
        this.num_quarto = num_quarto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getAnoReserva() {
        return anoReserva;
    }

    public void setAnoReserva(int anoReserva) {
        this.anoReserva = anoReserva;
    }

    public int getMesReserva() {
        return mesReserva;
    }

    public void setMesReserva(int mesReserva) {
        this.mesReserva = mesReserva;
    }

    public int getSemanaReserva() {
        return semanaReserva;
    }

    public void setSemanaReserva(int semanaReserva) {
        this.semanaReserva = semanaReserva;
    }
}
