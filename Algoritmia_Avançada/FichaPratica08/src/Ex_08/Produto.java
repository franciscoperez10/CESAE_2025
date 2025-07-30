package Ex_08;

public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEmStock = 0;

    public Produto(String nome, double preco, int quantidadeEmStock) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmStock = quantidadeEmStock;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmStock() {
        return quantidadeEmStock;
    }

    public void adquirirStock(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmStock += quantidade;
            System.out.println("Stock de " + nome + " corretamente adicionado");
        } else {
            System.out.println("Não existe stock disponível");

        }
    }

    public void venderProduto(int quantidade) {

    }

    public void exibirDetalhes () {
        System.out.println(this.nome + "");


}
}
