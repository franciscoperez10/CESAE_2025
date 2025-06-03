package Ex_02;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Francisco Perez", 30, 936255892, "fmlperez95@gmail.com");
        Pessoa pessoa2 = new Pessoa("Alfredo Costa", 18, 911911911, "alfredocosta@gmail.com");
        Pessoa pessoa3 = new Pessoa("Bárbara Silva", 17, 912912912, "barbaras@gmail.com");
        Pessoa pessoa4 = new Pessoa("Carlos Monteiro", 25, 933333987, "carlosmon@gmail.com");
        Pessoa pessoa5 = new Pessoa("Diogo Morgado", 45, 919919287, "diogomorgado@gmail.com");
        Pessoa pessoa6 = new Pessoa("Filipa Garcia", 28, 917390279, "filipagarcia@gmail.com");
        Pessoa pessoa7 = new Pessoa("Miguel Freitas", 33, 926183023, "miguelfreitas24@gmail.com");

        Sorteio sorteio = new Sorteio("Euromilhões", "50.000.000€");

        sorteio.inscreverParticipante(pessoa1);
        sorteio.inscreverParticipante(pessoa2);
        sorteio.inscreverParticipante(pessoa3);
        sorteio.inscreverParticipante(pessoa4);
        sorteio.inscreverParticipante(pessoa5);
        sorteio.inscreverParticipante(pessoa6);
        sorteio.inscreverParticipante(pessoa7);

        System.out.println("\nLista de Participantes:");
        sorteio.imprimirParticipantes();

        Pessoa vencedor = sorteio.sortear();
        System.out.println("\nVencedor:");
        System.out.println(vencedor.getNome() + " | " + vencedor.getIdade() + " | " + vencedor.getTelemovel() + " | " + vencedor.getEmail());
    }


}
