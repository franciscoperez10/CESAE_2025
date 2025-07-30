package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex03 {

    public static void imprimirFicheiro(String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

        }

        sc.close();

    }

    public static void copiarFicheiro(String caminhoOrigem, String caminhoDestino) throws FileNotFoundException {

        File ficheiroOrigem = new File(caminhoOrigem);

        File ficheiroDestino = new File(caminhoDestino);

        Scanner sc = new Scanner(ficheiroOrigem);

        PrintWriter printWriter = new PrintWriter(ficheiroDestino);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            printWriter.println(linha);
        }

        printWriter.close();


    }

    public static void main(String[] args) throws FileNotFoundException {
        copiarFicheiro("FichasPraticas/Ficheiros/exercicio_03_Alternativa01.txt", "FichasPraticas/Ficheiros/exercicio_03_1.txt");

    }


}
