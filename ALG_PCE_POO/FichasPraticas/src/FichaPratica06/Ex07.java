package FichaPratica06;

public class Ex07 {

    public static void quadrado(int linhas, int colunas, String character) {

    }

    public static int linhas(int[] vetor) {
        int linhas = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > linhas) {
                linhas = vetor[i];
            }
        }
        return linhas();
    }


    public static int colunas(int[] vetor) {
        int linhas = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > linhas) {
                linhas = vetor[i];
            }

            return colunas();
        }

    }

