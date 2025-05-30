package Ex_06;

public class Atleta {
    private String nome;
    private String modalidadeDesportiva;
    private double altura;
    private double peso;
    private String paisDeOrigem;
    private int rankingMundial;

    public Atleta(String nome, int rankingMundial, String modalidadeDesportiva, double peso, String paisDeOrigem, double altura) {
        this.nome = nome;
        this.rankingMundial = rankingMundial;
        this.modalidadeDesportiva = modalidadeDesportiva;
        this.peso = peso;
        this.paisDeOrigem = paisDeOrigem;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

}
