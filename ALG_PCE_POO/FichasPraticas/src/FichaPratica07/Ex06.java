package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) throws FileNotFoundException {
        String caminhoFicheiro = "FichasPraticas/Ficheiros/exercicio_06.txt";
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        String nomeMaisVelho ="";
        int total = 0, idade = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLinha = linha.split(",");

            for (int i = 0; i < itensDaLinha.length; i++) total += Integer.parseInt(itensDaLinha[i]); {

                if(idade < nomeMaisVelho) {
                    ;
                }
            }

            System.out.println(linha);
        }

        sc.close();
        System.out.println("A pessoa mais velha da lista é: " + idade);
    }
}
