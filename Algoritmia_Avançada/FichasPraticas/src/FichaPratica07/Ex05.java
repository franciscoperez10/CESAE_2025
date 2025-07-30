package FichaPratica07;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Ex05 {

    public static void main(String[] args) throws FileNotFoundException {
        String caminhoFicheiro = "FichasPraticas/Ficheiros/exercicio_05_31.txt";
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);
        int total = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLinha = linha.split(" ");

            for (int i = 0; i < itensDaLinha.length; i++) {
                total += Integer.parseInt(itensDaLinha[i]);
            }

            System.out.println(linha);
        }

        sc.close();
        System.out.println("A soma dos números no ficheiro é: " + total);
    }
}

