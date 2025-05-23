import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }
        return contagemLinhas;
    }

    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {

        int numeroFilmes = contarLinhas(caminho) - 1;

        String[][] matrizCompleta = new String[numeroFilmes][8];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        sc.nextLine();

        int numFilmeAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            System.arraycopy(linhaSeparada, 0, matrizCompleta[numFilmeAtual], 0, matrizCompleta[0].length);

            numFilmeAtual++;
        }
        return matrizCompleta;
    }

    public static void pesquisarFilmesTitulo(String[][] matriz, String tituloPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + tituloPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][3].equalsIgnoreCase(tituloPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][2]);
            }
        }
    }

    public static void pesquisarFilmesRating(String[][] matriz, String ratingPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + ratingPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][3].equalsIgnoreCase(ratingPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][2]);
            }
        }
    }

    public static void pesquisarFilmesDuracao(String[][] matriz, String duracaoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + duracaoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][4].equalsIgnoreCase(duracaoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][3]);
            }
        }
    }

    public static void pesquisarFilmesAno(String[][] matriz, String anoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + anoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][5].equalsIgnoreCase(anoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][4]);
            }
        }
    }

    public static void pesquisarFilmesEstudio(String[][] matriz, String estudioPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + estudioPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][6].equalsIgnoreCase(estudioPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][5]);
            }
        }
    }

    public static void pesquisarFilmesRealizador(String[][] matriz, String realizadorPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + realizadorPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][7].equalsIgnoreCase(realizadorPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][6]);
            }
        }
    }

    public static void pesquisarFilmesGenero(String[][] matriz, String generoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + generoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][8].equalsIgnoreCase(generoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][7]);
            }
        }
    }


// FUNÇÃO MENU PRINCIPAL // //REVER //

    public static void menuPrincipal(String[][] dadosLogin) {


        Scanner input = new Scanner(System.in);

        int tipoDeUtilizador;

        do {

            System.out.println("Selecione o seu tipo de utilizador: ");
            System.out.println("1. Administrador");
            System.out.println("2. Cliente");
            System.out.println("0. Sair");
            tipoDeUtilizador = input.nextInt();

            System.out.println();

            switch (tipoDeUtilizador) {
                case 1:
                    System.out.println("Administrador");
                    menuAdministrador();
                    break;

                case 2:
                    System.out.println("Cliente");
                    menuCliente();
                    break;

                case 0:
                    System.out.println("A sair do programa...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        } while (tipoDeUtilizador != 0);
    }

// ---------------------------- MENU ADMIN  --------------------------------- //

    public static void menuAdministrador() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("***** Menu Administrador *****");
            System.out.println("1. Consultar Ficheiros");
            System.out.println("2. Total de Ratings");
            System.out.println("3. Imprimir Todos os Estúdios");
            System.out.println("0. Sair do Menu");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) { // Colocar funções específicas
                case 1:
                    consultaDeFicheiros();
                    break;
                case 2:
                    totalDeRatings();
                    break;
                case 3:
                    imprimirTodosOsEstudios();
                    break;
                case 0:
                    System.out.println("A sair do menu....");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        } while (opcao != 0);
    }

    //REVER //
    public static void menuLogin(String[][] dadosLogin) {

        Scanner input = new Scanner(System.in);

        if (validarLogin(dadosLogin)) {;
        } else {
            System.out.println("Login inválido");
            System.out.println("1.Tente novamente");
            System.out.println("2. Regresse ao menu principal");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("1.Tente novamente");
                    break;
                case 2:
                    System.out.println("2. Regresse ao menu principal");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

        //REVER //
        public static boolean validarLogin(String caminho, String user, String pass) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        boolean access = false;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLista = linha.split(";");

            if (user.equals(itensDaLista[0]) && pass.equals(itensDaLista[1])) {
                System.out.println("Welcome");
                menuAdministrador(ficheiroParaMatriz(caminho));
                access = true;
                break;
            }
        }

        if (!access) {
            System.out.println("Login inválido! Try again.");
        }

        sc.close();
        return access;
    }

    //REVER //
    public static void login(String caminho) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        boolean access;

        do {
            System.out.print("Username: ");
            String user = input.next();
            input.nextLine();

            System.out.print("Password: ");
            String pass = input.next();

            access = validarLogin(caminho, user, pass);
        } while (!access);
    }
    }
        // TERMINAR //
        public static void consultaDeFicheiros() throws FileNotFoundException {
            Scanner in = new Scanner(new File("Ficheiros/IMDV/IMDV.csv"));

            System.out.println("Consulta de Ficheiros)";

            int contador = 0;

            while (in.hasNextLine()) {
                String linha = in.nextLine();
                String[] campos = linha.split(";");

                System.out.println();





                }
            }

        }


    }

    // TERMINAR //
    public static void totalDeRatings() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Ficheiros/IMDV/IMDV.csv"));

        System.out.println("Total de Ratings");

    }
    // TERMINAR //
    public static void imprimirTodosOsEstudios() {
       System.out.println("Estúdios");

       String [] estudiosUnicos = new String [filmes.length];
       int [] contadorFilmes = new int [filmes.length];
       int numeroDeEstudiosTotais = 0;

       for (int i = 0; i < filmes.length; i++) {
           String estudio = filmes[i][5];

    }

    // MENU CLIENTE // VALIDAR //

    public static void menuCliente() {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Registar utilizador");
            System.out.println("2. Imprimir catálogo");
            System.out.println("3. Imprimir catálogos gráficos");
            System.out.println("4. Imprimir Melhor Estúdio");
            System.out.println("5. Imprimir Pior Estúdio");
            System.out.println("6. Imprimir Critíca Mais Recente");
            System.out.println("7. Participe no nosso Quiz!");
            System.out.println("8. Imprimir Catálogo Estúdio");
            System.out.println("9. Imprimir Catálogo Categoria");
            System.out.println("0. Regresse ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Registar utilizador");
                    break;
                case 2:
                    System.out.println("Imprimir catálogo");
                    break;
                case 3:
                    System.out.println("Imprimir cátalogos gráficos");
                    break;
                case 4:
                    System.out.println("Imprimir Melhor Estúdio");
                    break;
                case 5:
                    System.out.println("Imprimir Pior Estúdio");
                    break;
                case 6:
                    System.out.println("Imprimir Crítica Mais Recente");
                    break;
                case 7:
                    System.out.println("Participe no nosso Quiz!");
                    break;
                case 8:
                    System.out.println("Imprimir Catálogo Estúdio");
                    break;
                case 9:
                    System.out.println("Imprimir Catálogo Categoria");
                    break;
                case 0:
                    System.out.println("Regresse ao Menu Principal");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void novoRegisto() {

            Scanner input = new Scanner(System.in);

            System.out.println("\n===== Registo de novo utilizador =====");

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Contacto: ");
            String contacto = input.nextLine();

            System.out.print("Email: ");
            String email = input.nextLine();

            System.out.println("--- Registo efetuado com sucesso! ---");
            System.out.println("Nome: " + nome);
            System.out.println("Contacto: " + contacto);
            System.out.println("Email: " + email);

            System.out.println("\nPressione Enter para continuar...");
            input.nextLine();
        }



    }

    // REVER E TERMINAR //

    public static void imprimirCatalogo() throws FileNotFoundException {
    String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

    System.out.println("\n============= Catálogo de Filmes =============");
    System.out.println("ID | Título | Rating | Duração | Ano | Estúdio | Realizador | Género");
    System.out.println("===============================================================================");

    for (int i = 0; i < dadosFilmes.length; i++) {
        System.out.println(dadosFilmes[i][0] + " | " + dadosFilmes[i][1] + " | " + dadosFilmes[i][2] +
                " | " + dadosFilmes[i][3] + " min | " + dadosFilmes[i][4] + " | " +
                dadosFilmes[i][5] + " | " + dadosFilmes[i][6] + " | " + dadosFilmes[i][7]);
    }

    System.out.println("===============================================================================");
    System.out.println("Total de filmes: " + dadosFilmes.length);

    Scanner input = new Scanner(System.in);
    System.out.println("\nPressione Enter para continuar...");
    input.nextLine();
}
    // TERMINAR //
    public static void imprimirMelhorEstudio() {
        System.out.println("Melhor Estúdio");
        String [] estudios = new String[estudios.length];
        double [] somaRatings = new double[];
        int [] contadorFilmes = new int [];
        int [] numEstudios = new int [];
    }

    // TERMINAR //
    public static void imprimirPiorEstudio() {
        System.out.println("Pior Estúdio");
        String[] estudios = new String[];
        double[] somaRatings = new double[];
        int[] contadorFilmes = new int[];
        int numEstudios = 0;
    }

    // FAZER //
    public static void imprimirCriticaMaisRecente() {

    }

    // FAZER //
    public static void menuQuiz() {

    }

    // FAZER //
    public static void imprimirCatalogoEstudio() {

    }
    // FAZER //
    public static void imprimirCatalogoCategoria() {

    }

    // FAZER //
    public static void main(String[] args) throws FileNotFoundException {
        menuPrincipal("Ficheiros/IMDV/IMDV.csv"));
    }
}
