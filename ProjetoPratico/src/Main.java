public static int [][] contarLinhas (String caminho) throws FileNotFoundException {

    File ficheiro = new File(caminho);
    Scanner sc = new Scanner(ficheiro);

    int contagemLinhas = 0;

    while (sc.hasNextLine()) {
        sc.nextLine();
        contagemLinhas++;
    }
    return contagemLinhas
}

public static String [][] ficheiroParaMatriz (String caminho) throws FileNotFoundException {

    int numeroFilmes = contarLinhas(caminho) - 1;

    String[][] matrizCompleta = new String[numeroFilmes][8];

    File ficheiro = new File(caminho);
    Scanner sc = new Scanner(ficheiro);
    sc.nextLine();

    int numFilmeAtual = 0;

    while (sc.hasNextLine()) {
        String linha = sc.nextLine();
        String[] linhaSeparada = linha.split(";");

        for (int i = 0; i < matrizCompleta[0].length; i++) {
            matrizCompleta[numFilmeAtual][i] = linhaSeparada[i];
        }

        numFilmeAtual++;
    }
        return matrizCompleta;
}

public static void pesquisarFilmesAno (String [][] matriz, String anoPesquisa) {
    System.out.println("\n_*_*_* Filmes de " anoPesquisa + "_*_*_*");

    for (int linha = 0; linha < matriz.length; linha++) {
        if (matriz[linha][5].equalsIgnoreCase(anoPesquisa) {
            System.out.println(matriz[linha][0] + " | " + matriz[linha][4]);
        }
    }
}

public static void pesquisarFilmesEstudio (String [][] matriz, String estudioPesquisa) {
    System.out.println("\n_*_*_* Filmes de " estudioPesquisa + "_*_*_*");

    for (int linha = 0; linha < matriz.length; linha++) {
        if (matriz[linha][6].equalsIgnoreCase(estudioPesquisa) {
            System.out.println(matriz[linha][0] + " | " + matriz[linha][5]);
        }
    }
}

public static void pesquisarFilmesRealizador (String [][] matriz, String realizadorPesquisa) {
    System.out.println("\n_*_*_* Filmes de " realizadorPesquisa + "_*_*_*");

    for (int linha = 0; linha < matriz.length; linha++) {
        if (matriz[linha][7].equalsIgnoreCase(realizadorPesquisa) {
            System.out.println(matriz[linha][0] + " | " + matriz[linha][6]);
        }
    }
}

public static void pesquisarFilmesGenero (String [][] matriz, String generoPesquisa) {
        System.out.println("\n_*_*_* Filmes de " generoPesquisa + "_*_*_*");

    for (int linha = 0; linha < matriz.length; linha++) {
        if (matriz[linha][8].equalsIgnoreCase(generoPesquisa)) {
            System.out.println(matriz[linha][0] + " | " + matriz[linha][7]);
        }
    }
}
}

// FUNÇÃO MENU PRINCIPAL //

public static void menuPrincipal (String[] args) { // Há forma de testar para ver se está a funcionar?
    // O menuPrincipal é uma matriz?

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

// ---------------- COMEÇAR AQUI --------------------------------- //

public static void menuAdministrador() {
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
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                System.out.println("A sair do menu....");
                break;
            default:
                System.out.println("Opção inválida, tente novamente");
        }
    }

    }
}

public static void menuCliente () {

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

