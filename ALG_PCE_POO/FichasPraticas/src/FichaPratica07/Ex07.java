package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex07 {

    public static void somaDosElementos(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);
        int linhas = 0; int palavras = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            linhas++;
            String [] itensDalinha = linha.split(" ");
            palavras += itensDalinha.length;
            System.out.println(linha);
        }

        sc.close();
        System.out.println("O número de linhas é: " + linhas);
        System.out.println("O número de palavras é: " + palavras);
    }

    public static void main(String[] args) throws FileNotFoundException {

        somaDosElementos("FichasPraticas/Ficheiros/exercicio_07.txt");


    }

}
