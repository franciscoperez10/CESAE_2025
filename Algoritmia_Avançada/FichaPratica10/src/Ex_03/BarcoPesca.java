package Ex_03;

import java.util.ArrayList;


public class BarcoPesca {

    private String nome;
    private String cor;
    private int anoFabrico = 2025;
    private int tripulacao;
    private double capacidadeCarga;
    private double pesoTotal = 0.0;
    private Marca marca;
    private ArrayList<Peixe> peixesPescado;
    private ArrayList<Marisco> mariscoPescado;

    public BarcoPesca(String nome, String cor, int anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.peixesPescado = new ArrayList<>(peixesPescado);
        this.mariscoPescado = new ArrayList<>(mariscoPescado);
    }

    public double calcularPesoAtual() {
        for (Peixe peixeAtual : peixesPescado) {
            pesoTotal += peixeAtual.getPeso();
        }


        for (Marisco mariscoAtual : mariscoPescado) {
            pesoTotal += mariscoAtual.getPeso();
        }

        return pesoTotal;
    }


    public void pescarPeixe(String peixe) {
        if (calcularPesoAtual() + peixe.getPeso() <= capacidadeCarga) {
            peixesPescado.add(peixe);
            System.out.println(peixe.getEspecie() + " foram adicionados.");
        } else {
            System.out.println("A carga máxima foi excedida");
        }
    }


    public void pescarMarisco(String marisco) {
        if (calcularPesoAtual() + marisco.getPeso() <= capacidadeCarga) {
            mariscoPescado.add(marisco);
            System.out.println(marisco.getEspecie() + " foram adicionados.");
        } else {
            System.out.println("A carga máxima foi excedida");
        }
    }


    public void largarPeixe(int indiceRemover) {
        this.largarPeixe().remove(indiceRemover);

    }

    public void largarMarisco(int indiceRemover) {
        this.largarMarisco().remove(indiceRemover);

    }

    public double calcularTotal() {
        double total = 0.0;

        for (Peixe peixeAtual : peixesPescado) {
            total += peixeAtual.getPeso() * peixeAtual.getPrecoKg();
        }

        for (Marisco mariscoAtual : mariscoPescado) {
            total += mariscoAtual.getPeso() * mariscoAtual.getPrecoKg();
        }

        return total;
    }

    public double salarioTripulacao() {

        double salario = (this.calcularTotal() * 0.6) / this.tripulacao;
        System.out.println("O salário da tripulação é de: " + salario + "€");

    }

}

