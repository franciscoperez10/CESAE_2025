public static void menuPrincipal (String[] args) {

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

public static void menuAdministrador() {

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
        System.out.println("6. Imprimir Crtíca Mais Recente");
        System.out.println("7. Participe no nosso Quiz!");
        System.out.println("8. Imprimir Catálogo Estúdio");
        System.out.println("9. Imprimir Catálogo Categoria");
        System.out.println("0. Regresse ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        opcao = input.nextInt();

        swich(opcao) {
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
                System.out.println("Registar Catálogo Categoria");
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

