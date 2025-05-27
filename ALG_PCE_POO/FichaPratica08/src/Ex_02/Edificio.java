package Ex_02;

public class Edificio {
    private int numeroDeAndares;
    private String nome;
    private String rua;
    private String cidade;
    private String corDaFachada;
    private boolean garagem;

    public Edificio(int numeroDeAndares, String nome, String rua, String cidade, String corDaFachada, boolean garagem) {
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.corDaFachada = corDaFachada;
        this.numeroDeAndares = numeroDeAndares;
        this.garagem = true;
    }


    public String getNome() {
        return this.nome;
    }

    public String getRua() {
        return this.rua;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getCorDaFachada() {
        return this.corDaFachada;
    }

    public void setCorDaFachada(String corDaFachada) {
        this.corDaFachada = corDaFachada;
    }

    public int getNumeroDeAndares() {
        return this.numeroDeAndares;
    }

    public boolean getGaragem() {
        return this.garagem;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Rua: " + rua);
        System.out.println("Cidade: " + cidade);
        System.out.println("Cor da Fachada: " + corDaFachada);
        System.out.println("Número de Andares: " + numeroDeAndares);
        System.out.println("Garagem: " + garagem);
    }
}
