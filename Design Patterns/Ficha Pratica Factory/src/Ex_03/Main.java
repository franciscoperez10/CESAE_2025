package Ex_03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Document> lista = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n***** Programa de Gestão de Documentos *****");
            System.out.println("1. Novo Documento");
            System.out.println("2. Visualizar Documentos");

            System.out.println("Insira a opção: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Tipo de Documento (Texto | Cáculo | Apresentação): ");
                    input.nextLine();
                    String tipoDocumento = input.nextLine();

                    System.out.println("Nome: ");
                    String nome = input.nextLine();

                    System.out.println("Autor: ");
                    String autor = input.nextLine();

                    Document documentoNovo = FabricaDocumentos.criarDocumento(tipoDocumento, nome, autor);

                    lista.add(documentoNovo);

                    break;

                case 2:
                    System.out.println("\nVisualizar Documento");

                    for (Document documentAtual : lista) {
                        documentAtual.open();
                        documentAtual.save();
                        documentAtual.close();
                    }

                    break;

                default:
                    System.out.println("Opção invlálida");
            }


        } while (opcao != 0);
    }
}
