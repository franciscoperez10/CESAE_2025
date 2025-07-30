package Ex_02;

/**
 * Classe Conta Bancária - Representa uma Conta de um Banco, contém um saldo e pode fazer operações bancárias básicas.
 */
public class ContaBancaria {
    private String iban;
    private String titular;
    private double saldo = 0;
    private int anoDeAbertura = 2025;
    private double margemDeEmprestimo = 0.5;
    private double valorEmDivida = 0;

    /**
     * Método construtor para <b>Conta Bancária</b>
     *
     * @param iban    IBAN - Identificador da <b>Conta Bancária</b>
     * @param titular Nome do Titular
     */
    public ContaBancaria(iban, titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
    }

    /**
     * Método para depositar dinheiro
     *
     * @param valor Valor a depositar (€)
     */
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println(valor + " € depositados na conta " + this.iban);
    }

    /**
     * Método para levantar dinheiro
     *
     * @param valor Valor a levantar (€)
     */
    public void levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println(valor + " € levantados da conta " + this.iban);
        } else {
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Levantamento de " + valor + " € recusado.");
        }
    }

    /**
     * Método que permite transferir dinheiro de uma Conta para a outra
     *
     * @param contaDestino Conta que vai receber o dinheiro
     * @param valor        Valor a transferir (€)
     */
    public void transferencia(ContaBancaria contaDestino, double valor) {
        if (this.saldo >= valor) { // Transferência válida
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println(valor + " € transferidos de " + this.iban + " para " + contaDestino.iban);
        } else { // Transferência inválida
            System.out.println("Saldo insuficiente na conta " + this.iban + ". Transferência de " + valor + " € para " + contaDestino.iban + " recusada.");
        }
    }

    /**
     * Método para exibir os detalhes de uma Conta
     */
    public void exibirDetalhes() {
        System.out.println(this.iban + " | " + this.titular + " | Saldo: " + this.saldo + " €");
    }

    public void pedirEmprestimo(ContaBancaria c1, double valor) {
        if (valorEmDivida > 0) {
            System.out.println("Empréstimo recusado");
        } else {
            System.out.println("Empréstimo aceite");
            System.out.println((this.saldo * this.margemDeEmprestimo));
        }

        double limiteEmprestimo = saldo * margemDeEmprestimo;
        if (valor > limiteEmprestimo) {
            System.out.println("Empréstimo recusado. O valor excede o máximo");
        } else {
            saldo += valor;
            valorEmDivida += valor;
            System.out.println("Empréstimo aceite. O valor pedido é de " + valor + "€");
        }

    }


    public void amortizarEmprestimo(ContaBancaria c1, double valor) {
        if (valor > valorEmDivida) {
            System.out.println("Erro! O valor a amortizar excede o montante da dívida.");
            return;
        }

        if (saldo < valor) {
            System.out.println("Erro! Saldo insuficiente para amortizar o empréstimo.");
            return;
        }

        saldo -= valor;
        valorEmDivida -= valor;
        System.out.println("Amortização realizada: " + valor + "€. Novo saldo: " + saldo + "€. Nova dívida: " + valorEmDivida + "€.");
    }


}
