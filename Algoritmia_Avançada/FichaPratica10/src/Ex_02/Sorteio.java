package Ex_02;

import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private String nome;
    private String premio;
    private ArrayList<Pessoa> listaDeParticipantes;

    public Sorteio(String nome, String premio) {
        this.nome = nome;
        this.premio = premio;
        this.listaDeParticipantes = new ArrayList<Pessoa>();
    }

    public void inscreverParticipante(Pessoa novoParticipante) {
        if (novoParticipante.getIdade() >= 18) {
            this.listaDeParticipantes.add(novoParticipante);
            System.out.println("Pode ser inscrito");
        } else {
            System.out.println("É menor de idade, não pode participar");
        }
    }

    public Pessoa sortear() {
        Random rd = new Random();
        int indexSorteado = rd.nextInt(listaDeParticipantes.size());
        return listaDeParticipantes.get(indexSorteado);
    }

    public void imprimirParticipantes() {
        for (Pessoa novoParticipante : this.listaDeParticipantes) {
            novoParticipante.exibirDetalhes();
        }
    }

}
