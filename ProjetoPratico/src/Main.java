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

    /**
     * Lê o ficheiro CSV, e devolve uma matriz de Strings com os dados dos filmes
     *
     * @param caminho
     * @return Matriz de filmes
     * @throws FileNotFoundException
     */
    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {
        int numeroFilmes = contarLinhas(caminho) - 1;
        // O ficheiro principal tem 8 colunas //
        String[][] matrizCompleta = new String[numeroFilmes][8];

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        sc.nextLine();

        int numeroFilmeAtual = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int i = 0; i < linhaSeparada.length && i < 8; i++) {
                matrizCompleta[numeroFilmeAtual][i] = linhaSeparada[i];
            }
            numeroFilmeAtual++;
        }
        sc.close();
        return matrizCompleta;
    }

    public static void pesquisarFilmesTitulo(String[][] matriz, String tituloPesquisa) {
        System.out.println("\n***** Filmes de " + tituloPesquisa + "*****");
        // Percorremos cada coluna do ficheiro //
        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][1].equalsIgnoreCase(tituloPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1]);
            }
        }
    }

    public static void pesquisarFilmesRating(String[][] matriz, String ratingPesquisa) {
        System.out.println("\n***** Filmes de " + ratingPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][2].equalsIgnoreCase(ratingPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][2]);
            }
        }
    }

    public static void pesquisarFilmesDuracao(String[][] matriz, String duracaoPesquisa) {
        System.out.println("\n***** Filmes de " + duracaoPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][3].equalsIgnoreCase(duracaoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][3]);
            }
        }
    }

    public static void pesquisarFilmesAno(String[][] matriz, String anoPesquisa) {
        System.out.println("\n***** Filmes de " + anoPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][4].equalsIgnoreCase(anoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][4]);
            }
        }
    }

    public static void pesquisarFilmesEstudio(String[][] matriz, String estudioPesquisa) {
        System.out.println("\n***** Filmes de " + estudioPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][5].equalsIgnoreCase(estudioPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][5]);
            }
        }
    }

    public static void pesquisarFilmesRealizador(String[][] matriz, String realizadorPesquisa) {
        System.out.println("\n***** Filmes de " + realizadorPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][6].equalsIgnoreCase(realizadorPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][6]);
            }
        }
    }

    public static void pesquisarFilmesGenero(String[][] matriz, String generoPesquisa) {
        System.out.println("\n***** Filmes de " + generoPesquisa + "*****");

        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][7].equalsIgnoreCase(generoPesquisa)) {
                System.out.println(matriz[linha][0] + " | " + matriz[linha][1]);
            }
        }
    }

    /**
     * Menu Principal de todo o programa
     * Permite que o utilizador escolha entre o modo de Administrador, Cliente ou terminar o programa
     *
     * @throws FileNotFoundException
     */
    public static void menuPrincipal() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int tipoDeUtilizador;

        // Permite que o utilizador escolha a sua tipologia, ou saia do programa //
        do {
            System.out.println("Seleccione o seu tipo de utilizador: ");
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

    /**
     * Permite aceder às opções, dentro do Menu do Administrador
     *
     * @throws FileNotFoundException
     */
    public static void menuAdministrador() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;
        // Lê os dados do ficheiro, e depois guarda numa matriz de Strings //
        String dados[][] = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

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
                    imprimirTodosOsEstudios();
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

    /**
     * Permite testar se o login funciona corretamente
     *
     * @param caminho
     * @param username
     * @param password
     * @return verdadeiro ("true") se os dados de login forem válidos, e falso se não.
     * @throws FileNotFoundException
     */
    public static boolean validarLogin(String caminho, String username, String password) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);
        boolean access = false;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] itensDaLista = linha.split(";");

            // Comparação com o ficheiro de login, para validar o acesso //
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

    /**
     * Função para o utilizador, seja o administrador ou o cliente entrarem no respetivo menu
     *
     * @throws FileNotFoundException
     */
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

    /**
     * Função para disponibilizar o ficheiro principal
     *
     * @throws FileNotFoundException
     */
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

    /**
     * Função para contar o número de rankings dos filmes
     *
     * @throws FileNotFoundException
     */
    public static void totalDeRatings() throws FileNotFoundException {
        int totalDeFilmes = contarLinhas("Ficheiros/IMDV/IMDV.csv");

        System.out.println("Total de Ratings");
        System.out.println("Total de ratings atribuídos: " + totalDeFilmes);
        System.out.println("\nPressione Enter para continuar");
        Scanner input = new Scanner(System.in);

    }

    /**
     * Função para imprimir os estúdios registados no ficheiro
     *
     * @throws FileNotFoundException
     */
    public static void imprimirTodosOsEstudios() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        String[] estudiosUnicos = new String[matriz.length];
        int numeroDeEstudiosTotais = 0;

        // Percorre os filmes, para identificar os estúdios únicos //
        for (int i = 0; i < matriz.length; i++) {
            String estudio = matriz[i][5];
            boolean verificarSeExiste = false;

            // Verifica se o estúdio está no vetor de estúdios únicos //
            for (int k = 0; k < numeroDeEstudiosTotais; k++) {
                if (estudiosUnicos[k].equalsIgnoreCase(estudio)) {
                    verificarSeExiste = true;
                    break;
                }
            }
            // Condição que verifica que, se o estúdio não estiver no vetor, é adicionado //
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
        input.nextLine();
    }

    /**
     * Permite aceder às várias funções dentro do menu do Cliente
     *
     * @throws FileNotFoundException
     */
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

    /**
     * Função que permite um(a) novo(a) utilizador(a) registar-se no sistema
     */
    public static void registoNovoUtilizador() {
        Scanner input = new Scanner(System.in);

        System.out.println("***** Registo de novo utilizador *****");
        System.out.print("Insira o Seu Nome: ");
        String nome = input.nextLine();

        System.out.print("Insira o Seu Contacto: ");
        int contacto = input.nextInt();
        input.nextLine(); // Limpeza do Buffer

        System.out.print("Insira o seu Email: ");
        String email = input.nextLine();

        System.out.println("Nome: " + nome);
        System.out.println("Contacto: " + contacto);
        System.out.println("Email: " + email);
        System.out.println("Utilizador Inserido com sucesso: " + nome + "| " + contacto + "| " + email);
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
    }

    /**
     * Função que permite a impressão do catálogo de filmes
     *
     * @throws FileNotFoundException
     */
    public static void imprimirCatalogo() throws FileNotFoundException {
        String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

        System.out.println("***** Catálogo de Filmes *****");
        System.out.println("Título | Rating | Duração | Ano | Estúdio | Realizador | Género");
        System.out.println("******");

        // Percorre os filmes da matriz e imprime cada um dos respetivos dados
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
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();

    }

    /**
     * Função que imprime o ficheiro "Copyright", à saída da execução do programa
     *
     * @throws FileNotFoundException
     */

    // Ficheiro alterado consoante indicado, com recurso à bibiloteca ASCII //
    public static void imprimirCopyright() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Ficheiros/IMDV/IMDV_Copyright.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    /**
     * Função para imprimir na consola, para depois ir buscar o catálogo gráfico
     *
     * @param caminho
     * @throws FileNotFoundException
     */
    public static void imprimirNaConsola(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(sc.nextLine());
        }

    }

    /**
     * Função que imprime os desenhos gráficos dos filmes pedidos, com recurso a menu
     *
     * @throws FileNotFoundException
     */
    public static void imprimirCatalogoGrafico() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha o catálogo que quer imprimir");
            System.out.println("1.Catálogo do Harry Potter");
            System.out.println("2.Catálogo do Interstellar");
            System.out.println("3.Catálogo do Lord of the Rings");
            System.out.println("4.Catálogo do Star Wars");
            System.out.println("0.Regresse ao Menu Principal");

            opcao = input.nextInt();
            switch (opcao) {

                case 1:
                    imprimirNaConsola("Ficheiros/IMDV/CatalogoGrafico/HarryPotter.txt");
                    break;
                case 2:
                    imprimirNaConsola("Ficheiros/IMDV/CatalogoGrafico/Interstellar.txt");
                    break;
                case 3:
                    imprimirNaConsola("Ficheiros/IMDV/CatalogoGrafico/LordOfTheRings.txt");
                    break;
                case 4:
                    imprimirNaConsola("Ficheiros/IMDV/CatalogoGrafico/StarWars.txt");
                    break;
                case 0:
                    System.out.println("Regressar ao Menu Principal");
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;

            }
        } while (opcao != 0);
    }

    /**
     * Função que imprime o estúdio com melhor classificação média (0-10)
     *
     * @throws FileNotFoundException
     */
    public static void imprimirMelhorEstudio() throws FileNotFoundException {
        String matriz[][];
        matriz = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        String melhorEstudio = matriz[1][5];
        double melhorMedia = 0;

        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            double somaReviews = 0;
            int somaFilmes = 0;


            for (int k = 1; k < matriz.length; k++) {
                if (matriz[k][5].equals(estudioAtual)) {
                    somaReviews += Double.parseDouble(matriz[k][2]);
                    somaFilmes++;
                }
            }

            double mediaAtual = somaReviews / somaFilmes;

            if (mediaAtual > melhorMedia) {
                melhorMedia = mediaAtual;
                melhorEstudio = estudioAtual;
            }
        }
        System.out.println(melhorEstudio + " média: " + melhorMedia);


    }

    /**
     * Função que imprime o estúdio com pior classificação média (0-10)
     * Segue a mesma lógica da função anterior
     *
     * @throws FileNotFoundException
     */
    public static void imprimirPiorEstudio() throws FileNotFoundException {
        String matriz[][];
        matriz = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        String piorEstudio = matriz[1][5];
        double piorMedia = 0;

        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            double somaReviews = 0;
            int somaFilmes = 0;


            for (int k = 1; k < matriz.length; k++) {
                if (matriz[k][5].equals(estudioAtual)) {
                    somaReviews += Double.parseDouble(matriz[k][2]);
                    somaFilmes++;
                }
            }

            double mediaAtual = somaReviews / somaFilmes;

            if (mediaAtual < piorMedia) {
                piorMedia = mediaAtual;
                piorEstudio = estudioAtual;
            }
        }
        System.out.println(piorEstudio + " média: " + piorMedia);
    }

    /**
     * Função que permite a impressão da crítica mais recente, ou seja, da "última" colocada em sistema
     *
     * @throws FileNotFoundException
     */
    public static void imprimirCriticaMaisRecente() throws FileNotFoundException {
        String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");

        // Começa com o ano e a posição do primeiro filme //
        int anoMaisRecente = Integer.parseInt(dadosFilmes[0][4]);
        int posicaoMaisRecente = 0;


        // Corre o ciclo para encontrar o filme mais recente //
        for (int i = 1; i < dadosFilmes.length; i++) {
            int ano = Integer.parseInt(dadosFilmes[i][4]);
            if (ano > anoMaisRecente) {
                anoMaisRecente = ano;
                posicaoMaisRecente = i;
            }
        }

        System.out.println("***** Crítica Mais Recente *****");
        System.out.println("Filme: " + dadosFilmes[posicaoMaisRecente][1]);
        System.out.println("Rating: " + dadosFilmes[posicaoMaisRecente][2]);
        System.out.println("Duração: " + dadosFilmes[posicaoMaisRecente][3] + " minutos");
        System.out.println("Ano: " + dadosFilmes[posicaoMaisRecente][4]);
        System.out.println("Estúdio: " + dadosFilmes[posicaoMaisRecente][5]);
        System.out.println("Realizador: " + dadosFilmes[posicaoMaisRecente][6]);
        System.out.println("\nPressione Enter para continuar");
    }

    /**
     * Função que permite participar num Quiz previamente desenhado
     *
     * @throws FileNotFoundException
     */
    public static void menuQuiz() throws FileNotFoundException {
        Scanner ficheiro = new Scanner(new File("Ficheiros/IMDV/Quiz.csv"));
        Scanner input = new Scanner(System.in);
        int pontuacao = 0, numeroDePerguntas = 0;

        if (ficheiro.hasNextLine()) ficheiro.nextLine();

        while (ficheiro.hasNextLine()) {
            String linha = ficheiro.nextLine();
            String[] elementosDasPerguntas = linha.split(";");

            // O ficheiro Quiz tem 6 perguntas //
            if (elementosDasPerguntas.length == 6) {
                String perguntas = elementosDasPerguntas[0];
                String resposta1 = elementosDasPerguntas[1];
                String resposta2 = elementosDasPerguntas[2];
                String resposta3 = elementosDasPerguntas[3];
                String resposta4 = elementosDasPerguntas[4];

                // A resposta certa está na coluna 5 //
                String respostaCerta = elementosDasPerguntas[5];

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
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
    }

    /**
     * Função que permite imprimir o catálogo de cada estúdio, mostrando cada um dos dados das categorias
     *
     * @throws FileNotFoundException
     */
    public static void imprimirCatalogoEstudio() throws FileNotFoundException {
        String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        Scanner input = new Scanner(System.in);

        System.out.println("Nome do Estúdio: ");
        String estudioAPesquisar = input.nextLine();
        System.out.println("\n***** Catálogo do Estudio *****");

        boolean catalogoDeEstudio = false;

        // Percorre os filmes da matriz, e imprime os dados de cada filme //
        for (int i = 0; i < dadosFilmes.length; i++) {
            if (dadosFilmes[i][5].equals(estudioAPesquisar)) {
                System.out.println("Título: " + dadosFilmes[i][1]);
                System.out.println("Rating: " + dadosFilmes[i][2]);
                System.out.println("Duração: " + dadosFilmes[i][3]);
                System.out.println("Ano: " + dadosFilmes[i][4]);
                System.out.println("Realizador: " + dadosFilmes[i][6]);
                System.out.println("Género: " + dadosFilmes[i][7]);

            }
        }

    }

    /**
     * Função que permite imprimir o catálogo, das várias categorias, de cada estúdio
     *
     * @throws FileNotFoundException
     */

    public static void imprimirCatalogoCategoria() throws FileNotFoundException {
        String[][] dadosFilmes = ficheiroParaMatriz("Ficheiros/IMDV/IMDV.csv");
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome da categoria: ");
        String categoriaAPesquisar = input.nextLine();
        System.out.println("\nFilmes da Categoria " + categoriaAPesquisar + ":");

        // Verifica se existe pelo menos um filme em cada categoria //
        boolean categoriaDeFilme = false;

        // Percorre os filmes, e imprime os que pertencem à categoria indicada
        for (int i = 0; i < dadosFilmes.length; i++) {
            // A categoria dos filmes está na coluna 7, e o ciclo ignora as maiúsculas e minúsculas //
            if (dadosFilmes[i][7].equalsIgnoreCase(categoriaAPesquisar)) {
                System.out.println(dadosFilmes[i][0] + " | " + dadosFilmes[i][1] + " | " + dadosFilmes[i][5]);
                categoriaDeFilme = true;
            }
        }
        // Se não existirem filmes da categoria //
        if (!categoriaDeFilme) {
            System.out.println("Não existem filmes nesta categoria");
        }
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();


    }

    public static void main(String[] args) throws FileNotFoundException {
        menuPrincipal();

    }
}