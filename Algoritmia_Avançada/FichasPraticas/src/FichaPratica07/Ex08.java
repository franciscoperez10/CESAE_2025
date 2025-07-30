package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex08 {

    public static void somaDasVendas(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        double totalVendas = 0.0;
        sc.nextLine();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLinha = linha.split(",");

            if (itensDaLinha.length >= 4) {
                int quantidadeVendida = Integer.parseInt(itensDaLinha[2]);
                double precoUnitario = Double.parseDouble(itensDaLinha[3]);
                totalVendas += quantidadeVendida * precoUnitario;
            }
        }

        sc.close();
        System.out.println("O valor total das vendas é: " + totalVendas + "€");
    }

    public static void main(String[] args) {
        try {
            somaDasVendas("FichasPraticas/Ficheiros/exercicio_08.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro não encontrado!");
        }
    }
}