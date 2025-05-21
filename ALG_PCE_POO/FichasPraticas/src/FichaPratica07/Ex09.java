package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex09 {

    public static void informacoesMusicas (String caminhoFicheiro) throws FileNotFoundException {
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);
        Scanner input = new Scanner(System.in);
        String linha = sc.nextLine();

        System.out.println("Introduza o género musical que quer ouvir: ");
        String genero = input.nextLine();


    }
}
