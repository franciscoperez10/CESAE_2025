package Ex_07;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Francisco", 30,"fmlperez95@gmail.com","Software Developer", 15);
        aluno1.felizAniversario();
        aluno1.exibirDetalhes();

        System.out.println(aluno1.getNome() + ": Aprovado ou Reprovado? " + aluno1.situacaoAprovacao());
        System.out.println();

        Aluno aluno2 = new Aluno("Roberto", 29, "roberto.couto@gmail.com", "Software Developer", 7.5 );
        aluno2.felizAniversario();
        aluno2.exibirDetalhes();

        System.out.println(aluno1.getNome() + " : Aprovado ou Reprovado? " + aluno2.situacaoAprovacao());
        System.out.println(" ");


    }
}
