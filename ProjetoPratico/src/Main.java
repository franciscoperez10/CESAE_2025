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
        sc.close();
        return contagemLinhas;
    }

    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {
        int numeroFilmes = contarLinhas(caminho) - 1;
        String[][] matrizCompleta = new String[numeroFilmes][8];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        sc.nextLine();

        int numeroFilmeAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            // Fixed the incomplete for loop
            for (int i = 0; i < linhaSeparada.length && i < 8; i++) {
                matrizCompleta[numeroFilmeAtual][i] = linhaSeparada[i];
            }
            numeroFilmeAtual++;
        }
        sc.close();
        return matrizCompleta;
    }

    public static void pesquisarFilmesTitulo(String[][] matriz, String tituloPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + tituloPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][1].equalsIgnoreCase(tituloPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1]);
            }
        }
    }

    public static void pesquisarFilmesRating(String[][] matriz, String ratingPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + ratingPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][2].equalsIgnoreCase(ratingPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][2]);
            }
        }
    }

    public static void pesquisarFilmesDuracao(String[][] matriz, String duracaoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + duracaoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][3].equalsIgnoreCase(duracaoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][3]);
            }
        }
    }

    public static void pesquisarFilmesAno(String[][] matriz, String anoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + anoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][4].equalsIgnoreCase(anoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][4]);
            }
        }
    }

    public static void pesquisarFilmesEstudio(String[][] matriz, String estudioPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + estudioPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][5].equalsIgnoreCase(estudioPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][5]);
            }
        }
    }

    public static void pesquisarFilmesRealizador(String[][] matriz, String realizadorPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + realizadorPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][6].equalsIgnoreCase(realizadorPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][6]);
            }
        }
    }

    public static void pesquisarFilmesGenero(String[][] matriz, String generoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " + generoPesquisa + "_*_*_*");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][7].equalsIgnoreCase(generoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1]);
            }
        }
    }

    public static void menuPrincipal() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int tipoDeUtilizador;

        do {
            System.out.println("Selecione o seu tipo de utilizador: ");
            System.out.println("1. Administrador");
            System.out.println("2. Cliente");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            tipoDeUtilizador = input.nextInt();


            switch (tipoDeUtilizador) {
                case 1:
                    System.out.println("Área de Administrador");
                    login();
                    break;
                case 2:
                    System.out.println("Área de Cliente");
                    menuCliente();
                    break;
                case 0:
                    System.out.println("A sair do programa...");
                    imprimirCopyright();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        } while (tipoDeUtilizador != 0);
        input.close();
    }

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
            input.nextLine();

            switch (opcao) {
                case 1:
                    consultaDeFicheiros();
                    break;
                case 2:
                    totalDeRatings();
                    break;
                case 3:
                    String[][] dados = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
                    imprimirTodosOsEstudios(dados);
                    break;
                case 0:
                    System.out.println("A sair do menu....");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        } while (opcao != 0);
        input.close();
    }


    public static boolean validarLogin(String caminho, String username, String password) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        boolean access = false;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLista = linha.split(";");

            if (username.equals(itensDaLista[0]) && password.equals(itensDaLista[1])) {
                System.out.println("Login efetuado com sucesso!");
                access = true;
                break;
            }
        }

        if (!access) {
            System.out.println("Login inválido! Tente novamente.");
        }

        sc.close();
        return access;
    }

    public static void login() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        boolean access = false;

        do {
            System.out.print("Username: ");
            String username = input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();


            access = validarLogin("Ficheiros/IMDV/IMDV_AdminLogin.csv", username, password);

            if (access) {
                menuAdministrador();
            }
        } while (!access);
    }

    public static void consultaDeFicheiros() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Ficheiros/IMDV/IMDV.csv"));

        System.out.println("***** Consulta de Ficheiros *****");

        while (in.hasNextLine()) {
            String linha = in.nextLine();
            System.out.println(linha);
        }
        in.close();

        System.out.println("Pressione no Enter para continuar");
        Scanner input = new Scanner(System.in);
        input.nextLine();

    }

    public static void totalDeRatings() throws FileNotFoundException {
        int totalDeFilmes = contarLinhas("Ficheiros/IMDV/IMDV.csv");

        System.out.println("Total de Ratings");
        System.out.println("Total de ratings atribuídos: " + totalDeFilmes);
        System.out.println("\nPressione Enter para continuar");
        Scanner input = new Scanner(System.in);

    }


    public static void imprimirTodosOsEstudios(String[][] matriz) {
        String[] estudiosUnicos = new String[matriz.length];
        int numeroDeEstudiosTotais = 0;

        for (int i = 0; i < matriz.length; i++) {
            String estudio = matriz[i][5];
            boolean verificarSeExiste = false;


            for (int k = 0; k < numeroDeEstudiosTotais; k++) {
                if (estudiosUnicos[k].equals(estudio)) {
                    verificarSeExiste = true;
                    break;
                }
            }

            if (!verificarSeExiste) {
                estudiosUnicos[numeroDeEstudiosTotais] = estudio;
                numeroDeEstudiosTotais++;
            }
        }

        System.out.println("***** Todos os Estúdios *****");
        for (int i = 0; i < numeroDeEstudiosTotais; i++) {
            System.out.println(estudiosUnicos[i]);
        }
        System.out.println("\nPressione Enter para continuar");
        Scanner input = new Scanner(System.in);
    }

    public static void menuCliente() throws FileNotFoundException {
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
            input.nextLine();

            switch (opcao) {
                case 1:
                    registoNovoUtilizador();
                    break;
                case 2:
                    imprimirCatalogo();
                    break;
                case 3:
                    imprimirCatalogoGrafico();
                    break;
                case 4:
                    imprimirMelhorEstudio();
                    break;
                case 5:
                    imprimirPiorEstudio();
                    break;
                case 6:
                    imprimirCriticaMaisRecente();
                    break;
                case 7:
                    menuQuiz();
                    break;
                case 8:
                    imprimirCatalogoEstudio();
                    break;
                case 9:
                    imprimirCatalogoCategoria();
                    break;
                case 0:
                    System.out.println("Regresse ao Menu Principal");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 0);
        input.close();
    }

    public static void registoNovoUtilizador() {
        Scanner input = new Scanner(System.in);

        System.out.println("***** Registo de novo utilizador *****");
        System.out.print("Insira o Seu Nome: ");
        String nome = input.nextLine();

        System.out.print("Insira o Seu Contacto: ");
        String contacto = input.nextLine();

        System.out.print("Insira o seu Email: ");
        String email = input.nextLine();

        System.out.println("Nome: " + nome);
        System.out.println("Contacto: " + contacto);
        System.out.println("Email: " + email);
        System.out.println("Utilizador Inserido com sucesso: " + nome + "| " + contacto + "| " + email);
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
    }

    public static void imprimirCatalogo() throws FileNotFoundException {
        String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

        System.out.println("***** Catálogo de Filmes *****");
        System.out.println("Título | Rating | Duração | Ano | Estúdio | Realizador | Género");
        System.out.println("******");

        for (int i = 0; i < dadosFilmes.length; i++) {
            System.out.println("Título: " + dadosFilmes[i][1]);
            System.out.println("Rating: " + dadosFilmes[i][2]);
            System.out.println("Duração: " + dadosFilmes[i][3] + " min");
            System.out.println("Ano: " + dadosFilmes[i][4]);
            System.out.println("Estúdio: " + dadosFilmes[i][5]);
            System.out.println("Realizador: " + dadosFilmes[i][6]);
            System.out.println("Género: " + dadosFilmes[i][7]);
            System.out.println("*****");
        }


        System.out.println("*****");
        System.out.println("Total de filmes: " + dadosFilmes.length);

        Scanner input = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();
        input.close();
    }

    public static void imprimirCopyright() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Ficheiros/IMDV/IMDV_Copyright.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    public static void imprimirCatalogoGrafico() throws FileNotFoundException {
        System.out.println("Funcionalidade em desenvolvimento...");
    }

    public static void imprimirMelhorEstudio() throws FileNotFoundException {
        System.out.println("Funcionalidade em desenvolvimento...");

    }

    public static void imprimirPiorEstudio() throws FileNotFoundException {
        System.out.println("Funcionalidade em desenvolvimento...");
    }

    public static void imprimirCriticaMaisRecente() throws FileNotFoundException{
        String [][] filmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

        int anoMaisRecente = Integer.parseInt(filmes[0][4]);
        int posicaoMaisRecente = 0;

        for (int i = 1; i < filmes.length; i++) {
            int ano = Integer.parseInt(filmes[i][4]);
            if (ano > anoMaisRecente) {
                anoMaisRecente = ano;
                posicaoMaisRecente = i;
            }
        }

        System.out.println("***** Crítica Mais Recente *****");
        System.out.println("Filme: " + filmes[posicaoMaisRecente][1]);
        System.out.println("Rating: " + filmes[posicaoMaisRecente][2]);
        System.out.println("Duração: " + filmes[posicaoMaisRecente][3] + " minutos");
        System.out.println("Ano: " + filmes[posicaoMaisRecente][4]);
        System.out.println("Estúdio: " + filmes[posicaoMaisRecente][5]);
        System.out.println("Realizador: " + filmes[posicaoMaisRecente][6]);
        System.out.println("Pressione Enter para continuar");
    }

    public static void menuQuiz() throws FileNotFoundException {
        Scanner ficheiro = new Scanner(new File("Ficheiros/IMDV/Quiz.csv"));
        Scanner input = new Scanner(System.in);
        int pontuacao = 0,numeroDePerguntas = 0;

        if (ficheiro.hasNextLine()) ficheiro.nextLine();

        while (ficheiro.hasNextLine()) {
            String linha = ficheiro.nextLine();
            String [] elementosDasPerguntas = linha.split(";");

            if (elementosDasPerguntas.length == 6) {
                String perguntas = elementosDasPerguntas[0];
                String resposta1 = elementosDasPerguntas[1];
                String resposta2 = elementosDasPerguntas[2];
                String resposta3 = elementosDasPerguntas[3];
                String resposta4 = elementosDasPerguntas[4];
                String respostaCerta = elementosDasPerguntas [5];

                System.out.println("\n" + perguntas);
                System.out.println("1) " + resposta1);
                System.out.println("2) " + resposta2);
                System.out.println("3) " + resposta3);
                System.out.println("4) " + resposta4);
                System.out.println("Resposta (1-4): ");
                String resposta = input.nextLine();

                if (resposta.equals(respostaCerta)) {
                    System.out.println("Correto");
                    pontuacao++;
                } else {
                    System.out.println("Errado! A resposta correta é a: " + respostaCerta);
                }
                numeroDePerguntas++;
            }
        }
        ficheiro.close();

        System.out.println("\nPontuação Total: " + pontuacao + " em " + numeroDePerguntas);
        System.out.println("Pressione Enter para continuar");
        input.nextLine();
    }

    public static void imprimirCatalogoEstudio() throws FileNotFoundException {
       String [][] filmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
       Scanner input = new Scanner(System.in);

        System.out.println("Nome do Estúdio: ");
        String estudioAPesquisar = input.nextLine();
        System.out.println("\n***** Catálogo do Estudio *****");

        boolean catalogoDeEstudio = false;
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i][5].equals(estudioAPesquisar)) {
                System.out.println("Título: " + filmes[i][1]);
                System.out.println("Rating: " + filmes[i][2]);
                System.out.println("Duração: " + filmes[i][3]);
                System.out.println("Ano: " + filmes[i][4]);
                System.out.println("Realizador: " + filmes[i][6]);
                System.out.println("Género: " + filmes[i][7]);

            }
        }

    }

    public static void imprimirCatalogoCategoria() throws FileNotFoundException {
        String [][] filmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome da categoria: ");
        String categoriaAPesquisar = input.nextLine();
        System.out.println("\nFilmes da Categoria " + categoriaAPesquisar + ":");

        boolean categoriaDeFilme = false;
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i][7].equalsIgnoreCase(categoriaAPesquisar)) {
                System.out.println(filmes[i][0] + " | " + filmes[i][1] + " | " + filmes[i][5]);
                categoriaDeFilme = true;
            }
        }
        if (!categoriaDeFilme) {
            System.out.println("Não existem filmes nesta categoria");
        }
        System.out.println("Pressione Enter para continuar");
        input.nextLine();


    }

    public static void main(String[] args) throws FileNotFoundException {
        menuPrincipal();
    }
}