package Jogo;

import Entidades.*;
import Itens.*;
import AudioFiles.Audio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe Principal da Guerra das Estrelas.
 * Cria o Herói, define o fluxo do jogo, as salas e as interações com o utilizador
 */
public class Jogo {
    /**
     * Introdução e formas de jogar
     * Regras do jogo
     */
    public static void mostrarIntroducao() {
        System.out.println("***************************************************");
        System.out.println("              BEM-VINDO À GUERRA DAS ESTRELAS      ");
        System.out.println("***************************************************");
        System.out.println("Neste RPG, assumes o papel de um herói numa galáxia em guerra.");
        System.out.println("O teu objetivo é atravessar um labirinto perigoso e derrotar inimigos.");
        System.out.println("Tens de fazer escolhas estratégicas e chegar ao fim da aventura com vida.");
        System.out.println();
        System.out.println("***** COMO JOGAR *****");
        System.out.println("- Escolhe o tipo de herói: Jedi, Rebel ou Mandalorian.");
        System.out.println("- Escolhe a dificuldade: Fácil (300 pontos, 20 moedas de ouro) ou Difícil (220 pontos, 15 moedas de ouro).");
        System.out.println("- Distribui os pontos de criação entre VIDA (1 ponto = 1 vida) e FORÇA (5 pontos = 1 força).");
        System.out.println("- Compra armas, poções e consumíveis na loja do Vendedor, se quiseres e se tiveres ouro para tal.");
        System.out.println("- Avança pelas salas do labirinto, enfrenta inimigos, armadilhas e toma decisões.");
        System.out.println("- Usa poções para recuperar vida ou aumentar a força após cada sala.");
        System.out.println("- O combate é por turnos e cada classe tem regras especiais de ataque.");
        System.out.println("- Podes ganhar o jogo,chegando ao fim do labirinto, ou perder se a tua vida chegar a zero.");
        System.out.println();
        System.out.println("***** REGRAS *****");
        System.out.println("1. Cada combate termina quando um dos lados fica sem vida.");
        System.out.println("2. Só podes usar o ataque especial uma vez por cada combate.");
        System.out.println("3. O vendedor só te mostra 10 itens aleatórios de cada vez.");
        System.out.println("4. Se tentares comprar alguma coisa, e não tiveres ouro suficiente, ou um item que não seja permitido na tua classe, a compra falha.");
        System.out.println("5. Se usares uma poção de vida que excede o teu máximo, a poção só funciona até ao máximo de vida (100HP) e és avisado de tal.");
        System.out.println("6. Podes jogar novamente ou criar uma nova personagem se/após perderes.");
        System.out.println();
        System.out.println("Boa sorte, herói! Que a Força esteja contigo.");
        System.out.println("***************************************************");
        System.out.println();
    }

    /**
     * Permite a criação do Herói
     * Permite a escolha da Dificuldade
     *
     * @return Herói
     */
    public static Heroi criarPersonagem() {
        Scanner sc = new Scanner(System.in);

        int escolhaHeroi = -1;
        // Garantir que o utilizador insere um número entre 1 e 3
        while (escolhaHeroi < 1 || escolhaHeroi > 3) {
            System.out.println("Escolhe o herói com que vais explorar a galáxia: ");
            System.out.println("1 - Jedi");
            System.out.println("2 - Rebel");
            System.out.println("3 - Mandalorian");
            System.out.print("Opção: ");
            escolhaHeroi = sc.nextInt();
            if (escolhaHeroi < 1 || escolhaHeroi > 3) {
                System.out.println("Opção inválida! Tenta novamente.");
            }
        }
        sc.nextLine();

        int escolhaDificuldade = -1;
        // Raciocínio similar à lógica de cima, ou seja, escolher 1 ou 2
        while (escolhaDificuldade < 1 || escolhaDificuldade > 2) {
            System.out.println("\nEscolhe a dificuldade:");
            System.out.println("1 - Fácil (300 pontos de criação, 20 ouro)");
            System.out.println("2 - Difícil (220 pontos de criação, 15 ouro)");
            System.out.print("Opção: ");
            escolhaDificuldade = sc.nextInt();
            if (escolhaDificuldade < 1 || escolhaDificuldade > 2) {
                System.out.println("Opção inválida! Tenta novamente.");
            }
        }
        sc.nextLine();


        int pontosCriacao;
        int ouro;

        // Seguindo o enunciado, a distribuição de pontos consoante a dificuldade escolhida
        if (escolhaDificuldade == 1) {
            pontosCriacao = 300;
            ouro = 20;
        } else {
            pontosCriacao = 220;
            ouro = 15;
        }

        int vida = 0;
        int forca = 0;


        while (pontosCriacao > 0) {
            System.out.println("\nPontos de criação restantes: " + pontosCriacao);
            System.out.println("Quantos pontos queres atribuir a VIDA? (1 ponto de criação = 1 vida)");
            int pontosVida = sc.nextInt();
            System.out.println("Quantos pontos queres atribuir a FORÇA? (5 pontos de criação = 1 força)");
            int pontosForca = sc.nextInt();

            // Protecção em caso de valores negativos
            if (pontosVida < 0 || pontosForca < 0) {
                System.out.println("Erro. Não podes atribuir valores negativos. Tenta novamente.");
            } else {
                int preco = pontosVida + (pontosForca * 5);
                if (preco > pontosCriacao) {
                    System.out.println("Distribuição inválida! Tenta novamente.");
                } else {
                    vida += pontosVida;
                    forca += pontosForca;
                    pontosCriacao -= preco;
                }
            }
        }


        System.out.print("\nEscolhe o nome do teu herói: ");
        String nome = sc.next();

        Heroi heroi = null;
        // Switch case para o utilizador escolher a personagem com que quer jogar
        switch (escolhaHeroi) {
            case 1:
                heroi = new Jedi(nome, vida, vida, forca, 1, 10, ouro, null, new ArrayList<>(), "Poder da Força", 0, 0, 0, 0);
                break;
            case 2:
                heroi = new Rebel(nome, vida, vida, forca, 1, 10, ouro, null, new ArrayList<>(), "Resistência", 0, 10);
                break;
            case 3:
                heroi = new Mandalorian(nome, vida, vida, forca, 1, 10, ouro, null, new ArrayList<>(), "Armadura Beskar", 0, 100, 100, 5);
                break;
            default:
                System.out.println("Classe inválida. Vai ser criado um Jedi.");
                heroi = new Jedi(nome, vida, vida, forca, 1, 10, ouro, null, new ArrayList<>(), "Poder da Força", 0, 0, 0, 0);
        }

        System.out.println("\nHerói criado com sucesso!");
        heroi.mostrarDetalhes();
        return heroi;
    }

    /**
     * Método principal responsável por "correr" o jogo
     * Permite gerar eventos aleatórios em cada sala do jogo
     *
     * @param heroi
     */
    public static void guerraDasEstrelas(Heroi heroi) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nBem-vindo à Guerra das Estrelas!");
        System.out.println("\nHá muito tempo, numa galáxia muito, muito distante, iniciou-se uma guerra entre duas classes de guerreiros: os membros da Ordem Jedi, e os sombrios Sith.");
        System.out.println("\nO teu objetivo é, através de um dos membros aliados: Jedi, Rebel ou Mandalorian, enfrentar os teus inimigos, percorrendo um perigoso labirinto.");
        System.out.println("\nQuando te sentires perdido, lembra-te do mantra Mandaloriano: This is the Way!");

        // Instancia e devolve a lista de itens que estão disponíveis na loja do vendedor
        ArrayList<ItemHeroi> stock = instanciarItens();
        Vendedor vendedor = new Vendedor(stock, "Watoo");

        // Loja do Vendedor
        boolean comprar = true;
        ArrayList<ItemHeroi> itensVisiveis = vendedor.imprimirLoja();
        while (comprar) {
            System.out.println("\nEscolhe o número do item que desejas comprar, ou pressiona '0' para avançar sem comprar:");
            int escolherItem = sc.nextInt();
            sc.nextLine();
            if (escolherItem == 0) {
                comprar = false;
            } else if (escolherItem < 1 || escolherItem > itensVisiveis.size()) {
                System.out.println("Item inválido.");
            } else {
                ItemHeroi itemSelecionado = itensVisiveis.get(escolherItem - 1);
                vendedor.vender(heroi, itemSelecionado);
            }
        }

        ArrayList<Inimigo> inimigos = instanciarInimigos();
        ArrayList<String> salas = instanciarSalas();

        // A ideia deste jogo é que a sala seja sempre aleatória, ou seja, o jogador não sabe o que lhe espera
        // O jogador nunca sabe se vai enfrentar um inimigo, regressar ao vendedor, descobrir uma poção ou cair numa armadilha
        int salaAtual = 0;
        Random random = new Random();
        while (salaAtual < salas.size()) {
            System.out.println("\n***** Começa a Aventura! *****");
            System.out.println("\nEstás na sala: " + salas.get(salaAtual));

            int evento = random.nextInt(100);

            // Cada uma das salas, vendedor,armadilha ou poção é definida probabilísticamente
            if (evento < 40) {
                Inimigo inimigo = inimigos.get(random.nextInt(inimigos.size()));
                System.out.println("Apareceu um inimigo! Um " + inimigo.getNome());
                boolean ganhar = heroi.atacar(inimigo);
                if (!ganhar) {
                    System.out.println("\nPerdeste! O Lado Negro da Força foi mais poderoso!");
                    return;
                } else {
                    inimigos.remove(inimigo);
                }
            } else if (evento < 60) {
                System.out.println("\nRegressaste ao vendedor!");
                heroi.mostrarResumoHeroi();
                boolean comprarSala = true;
                ArrayList<ItemHeroi> itensVisiveisSala = vendedor.imprimirLoja();
                while (comprarSala) {
                    System.out.println("Escolhe o número do item que desejas comprar, ou pressiona '0' para avançar:");
                    int escolherItemSala = sc.nextInt();
                    sc.nextLine();
                    if (escolherItemSala == 0) {
                        comprarSala = false;
                    } else if (escolherItemSala < 1 || escolherItemSala > itensVisiveisSala.size()) {
                        System.out.println("Item inválido.");
                    } else {
                        ItemHeroi itemSelecionado = itensVisiveisSala.get(escolherItemSala - 1);
                        vendedor.vender(heroi, itemSelecionado);
                    }
                }
            } else if (evento < 80) {
                int dano = random.nextInt(30) + 1;
                heroi.setVidaAtual(heroi.getVidaAtual() - dano);
                System.out.println("Caíste numa armadilha! Perdeste " + dano + " pontos de vida.");
                System.out.println("Vida atual: " + heroi.getVidaAtual() + "/" + heroi.getVidaMax());

                if (heroi.getVidaAtual() <= 0) {
                    System.out.println("Foste derrotado nesta aventura. Tenta novamente para alcançar a vitória!");
                    return;
                }
            } else {
                System.out.println("Encontraste uma poção de vida!");
                heroi.getInventario().add(new Pocao("Poção Encontrada", 0, null, "Cura 15 HP", 1, 15, 0));
            }

            if (heroi.getInventario().size() > 0) {
                System.out.println("Queres usar uma poção? (1=Sim, 0=Não)");
                int usar = sc.nextInt();
                sc.nextLine();
                if (usar == 1) {
                    heroi.usarPocao();
                }
            }
            heroi.mostrarResumoHeroi();

            if (salaAtual < salas.size() - 1) {
                System.out.println("\nQueres avançar para a próxima sala? (1=Sim, 0=Não)");
                int avancar = sc.nextInt();
                if (avancar == 1) {
                    salaAtual++;
                } else {
                    System.out.println("\nDecidiste não avançar. A tua jornada termina aqui, mas podes tentar novamente sempre que quiseres.");
                    break;
                }
            } else {
                System.out.println("\nParabéns! Chegaste ao fim do labirinto e venceste o jogo!");
                break;
            }
        }
        sc.close();
    }

    /**
     * Instancia e devolve a lista de itens que estão disponíveis na loja do vendedor
     *
     * @return ArrayList <ItemHeroi> com os itens disponíveis
     */
    public static ArrayList<ItemHeroi> instanciarItens() {
        ArrayList<ItemHeroi> stock = new ArrayList<>();
        ArrayList<HeroisPermitidos> permitidos = new ArrayList<>();
        permitidos.add(HeroisPermitidos.JEDI);
        permitidos.add(HeroisPermitidos.REBEL);
        permitidos.add(HeroisPermitidos.MANDALORIAN);

        // Armas principais
        stock.add(new ArmaPrincipal("Sabre de Luz", 25, permitidos, 20, 35));
        stock.add(new ArmaPrincipal("Blaster", 15, permitidos, 12, 22));
        stock.add(new ArmaPrincipal("Rifle de Precisão", 20, permitidos, 15, 28));
        stock.add(new ArmaPrincipal("Vibroblade", 18, permitidos, 14, 25));
        stock.add(new ArmaPrincipal("DDC Defebder", 35, permitidos, 20, 30));
        stock.add(new ArmaPrincipal("Sabre Duplo", 30, permitidos, 25, 40));

        // Poções
        stock.add(new Pocao("Poção de Vida", 10, permitidos, "Aumenta a vida em 25 HP", 1, 25, 0));
        stock.add(new Pocao("Poção Regenerativa", 6, permitidos, "Cura a vida em 10 HP", 1, 10, 0));
        stock.add(new Pocao("Poção de Força", 12, permitidos, "Aumenta a força em 5", 1, 0, 5));
        stock.add(new Pocao("Super Poção", 20, permitidos, "Cura 50 HP e aumenta força", 1, 50, 3));
        stock.add(new Pocao("Elixir da Vida", 15, permitidos, "Cura 35 HP", 1, 35, 0));
        stock.add(new Pocao("Poção Bakta", 25, permitidos, "Cura completa", 1, 100, 0));

        // Consumíveis de combate
        stock.add(new ConsumivelCombate("Lança-Chamas", 10, permitidos, "Permite desferir um golpe usando fogo", 1, 10));
        stock.add(new ConsumivelCombate("Granada Térmica", 8, permitidos, "Dano explosivo", 1, 25));
        stock.add(new ConsumivelCombate("Explosivo", 12, permitidos, "Grande dano instantâneo", 1, 35));
        stock.add(new ConsumivelCombate("Bomba de Fotões", 6, permitidos, "Dano moderado", 1, 15));
        stock.add(new ConsumivelCombate("Detonador", 10, permitidos, "Dano médio", 1, 20));


        return stock;
    }

    /**
     * * Instancia e devolve a lista de inimigos do jogo.
     *
     * @return ArrayList<Inimigo> com todos os inimigos possíveis
     */
    public static ArrayList<Inimigo> instanciarInimigos() {
        ArrayList<Inimigo> inimigos = new ArrayList<>();

        // Inimigos Sith
        inimigos.add(new Sith("Darth Malgus", 100, 100, 20, 3, 15, 25, 18, 12, 25));
        inimigos.add(new Sith("Darth Bane", 120, 120, 22, 4, 18, 30, 20, 15, 30));
        inimigos.add(new Sith("Darth Vader", 250, 250, 30, 5, 20, 40, 25, 30, 50));

        // Inimigos Stormtroopers
        inimigos.add(new Stormtrooper("Captain Phasma", 80, 80, 12, 1, 8, 10, 10, 8));
        inimigos.add(new Stormtrooper("FN-2199", 100, 1000, 14, 2, 10, 12, 12, 10));
        inimigos.add(new Stormtrooper("Dark Trooper", 115, 115, 20, 4, 20, 12, 15, 10));

        // Inimigos Separatists
        inimigos.add(new Separatist("Lok Durd", 105, 105, 12, 1, 15, 20, 12, 11, 7));
        inimigos.add(new Separatist("Count Dooku", 120, 120, 25, 4, 20, 35, 22, 18, 10));
        inimigos.add(new Separatist("General Grievous", 100, 100, 16, 2, 12, 18, 15, 12, 8));

        return inimigos;
    }

    /**
     * Instancia e devolve a lista de salas do labirinto criadas para o jogador
     *
     * @return ArrayList <String> com o nome de cada uma salas criadas
     */
    public static ArrayList<String> instanciarSalas() {
        ArrayList<String> salas = new ArrayList<>();
        salas.add("Entrada do Labirinto");
        salas.add("The Cockpit");
        salas.add("The Throne Room");
        salas.add("Carbon-Freezing Chamber");
        salas.add("The Detention Block");
        salas.add("Hut Cave");
        salas.add("Coruscant");
        salas.add("Corredor Final");
        return salas;
    }

    /**
     * Main do programa
     * Começa com a música da Guerra das Estrelas, mostra a introdução.
     * Apresenta a criação da Personagem
     * Executa e termina o programa
     *
     * @param args
     */
    public static void main(String[] args) {
        Audio.playMusic("src/AudioFiles/Star Wars Main Theme.wav");
        Scanner sc = new Scanner(System.in);
        boolean jogar = true;

        // Método que indica as regras do jogo
        mostrarIntroducao();

        // Ciclo while para que o jogo comece efetivamente, criando a personagem e correndo a Guerra das Estrelas
        while (jogar) {
            Heroi heroi = criarPersonagem();
            guerraDasEstrelas(heroi);

            System.out.println("\nQueres jogar novamente?");
            System.out.println("1 - Jogar com nova personagem");
            System.out.println("2 - Sair");
            int escolha = sc.nextInt();
            if (escolha != 1) {
                jogar = false;
            }
        }
        sc.close();
    }

}
