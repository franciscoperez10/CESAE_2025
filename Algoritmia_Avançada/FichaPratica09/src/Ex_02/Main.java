package Ex_02;

public class Main {
    public static void main(String[] args) {

        ContaBancaria c1 = new ContaBancaria("PT50 123", "Vitor");
        ContaBancaria c2 = new ContaBancaria("PT50 555", "Quim");
        ContaBancaria c3 = new ContaBancaria("PT50 111", "Joana");

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");

        // Fazer 3 depósitovs
        c1.depositar(500);
        c2.depositar(10);
        c3.depositar(2000);

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");

        c1.depositar(1000);
        c2.depositar(500);
        c3.depositar(3000);

        // Testar os levantamentos
        c1.levantar(200);
        c2.levantar(1000);
        c3.levantar(50);

        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");


        c1.transferencia(c2, 50);


        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");


        c2.transferencia(c3, 2000);


        System.out.println("_______________________________________");
        c1.exibirDetalhes();
        c2.exibirDetalhes();
        c3.exibirDetalhes();
        System.out.println("_______________________________________");
        System.out.println("_______________________________________");
        System.out.println("Pedir Empréstimos");

        c1.pedirEmprestimo(c1, 50000);
        c2.pedirEmprestimo(c2, 2000);
        c3.pedirEmprestimo(c3, 1000);
        System.out.println("_______________________________________");
        System.out.println("Amortizar Empréstimos");

        c1.amortizarEmprestimo(c1, 400);
        c2.amortizarEmprestimo(c2, 500);
        c3.amortizarEmprestimo(c3, 600);



    }



}
