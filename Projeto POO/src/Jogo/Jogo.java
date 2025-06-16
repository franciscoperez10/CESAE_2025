package Jogo;

import Entidades.*;
import Itens.*;
import AudioFiles.Audio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

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
        System.out.println("- Escolhe a dificuldade: Fácil (300 pontos, 20 ouro) ou Difícil (220 pontos, 15 ouro).");
        System.out.println("- Distribui os pontos de criação entre VIDA (1 ponto = 1 vida) e FORÇA (5 pontos = 1 força).");
        System.out.println("- Compra armas, poções e consumíveis na loja do Vendedor, se quiseres e se tiveres ouro para tal.");
        System.out.println("- Avança pelas salas do labirinto, enfrenta inimigos, armadilhas e toma decisões.");
        System.out.println("- Usa poções para recuperar vida ou aumentar força após cada sala.");
        System.out.println("- O combate é por turnos e cada classe tem regras especiais de ataque.");
        System.out.println("- Podes ganhar o jogo,chegando ao fim do labirinto, ou perder se a tua vida chegar a zero.");
        System.out.println();
        System.out.println("***** REGRAS *****");
        System.out.println("1. Cada combate termina quando um dos lados fica sem vida.");
        System.out.println("2. Só podes usar o ataque especial uma vez por combate.");
        System.out.println("3. O vendedor só mostra 10 itens aleatórios de cada vez.");
        System.out.println("4. Se tentares comprar alguma coisa, e não tiveres ouro suficiente, ou um item que não seja permitido na tua classe, a compra falha.");
        System.out.println("5. Se usares uma poção de vida que excede o teu máximo, a poção só funciona até ao máximo de vida (100HP) e és avisado de tal.");
        System.out.println("6. Podes tentar jogar novamente ou criar nova personagem após perder.");
        System.out.println();
        System.out.println("Boa sorte, herói! Que a Força esteja contigo.");
        System.out.println("***************************************************");
        System.out.println();
    }


    public static Heroi criarPersonagem() {
        Scanner sc = new Scanner(System.in);

        int escolhaHeroi = -1;
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


    public static void guerraDasGalaxias(Heroi heroi) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nBem-vindo à Guerra das Estrelas!");
        System.out.println("\nHá muito tempo, numa galáxia muito, muito distante, iniciou-se uma guerra entre duas classes de guerreiros: os membros da Ordem Jedi, e os sombrios Sith.");
        System.out.println("\nO teu objetivo é, através de um dos membros aliados: Jedi, Rebel ou Mandalorian, enfrentar os teus inimigos, percorrendo um perigoso labirinto.");
        System.out.println("\n Quando te sentires perdido, lembra-te do mantra Mandaloriano: This is the Way!");

        ArrayList<ItemHeroi> stock = instanciarItens();
        Vendedor vendedor = new Vendedor(stock, "Merchant");

        // PRIMEIRA LOJA
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

        int salaAtual = 0;
        Random random = new Random();
        while (salaAtual < salas.size()) {
            System.out.println("\nEstás na sala: " + salas.get(salaAtual));

            int evento = random.nextInt(100);

            if (evento < 40) {
                Inimigo inimigo = inimigos.get(random.nextInt(inimigos.size()));
                System.out.println("Apareceu um inimigo! Um " + inimigo.getNome());
                boolean ganhar = heroi.atacar(inimigo);
                if (!ganhar) {
                    System.out.println("\nPerdeste! Queres jogar novamente?");
                    return;
                } else {
                    // Aqui tens acesso à lista 'inimigos'
                    inimigos.remove(inimigo); // REMOVE O INIMIGO DERROTADO DA LISTA
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
                    System.out.println("Foste derrotado nesta aventura. Tenta novamente para alcançar a vitória!?");
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

        // Poções
        stock.add(new Pocao("Poção de Vida", 10, permitidos, "Aumenta a vida em 25 HP", 1, 25, 0));
        stock.add(new Pocao("Poção de Força", 12, permitidos, "Aumenta a força em 5", 1, 0, 5));
        stock.add(new Pocao("Super Poção", 20, permitidos, "Cura 50 HP e aumenta força", 1, 50, 3));
        stock.add(new Pocao("Elixir da Vida", 15, permitidos, "Cura 35 HP", 1, 35, 0));

        // Consumíveis de combate
        stock.add(new ConsumivelCombate("Granada Térmica", 8, permitidos, "Dano explosivo", 1, 25));
        stock.add(new ConsumivelCombate("Explosivo", 12, permitidos, "Grande dano instantâneo", 1, 35));
        stock.add(new ConsumivelCombate("Bomba de Fotões", 6, permitidos, "Dano moderado", 1, 15));
        stock.add(new ConsumivelCombate("Detonador", 10, permitidos, "Dano médio", 1, 20));

        // Itens adicionais
        stock.add(new ArmaPrincipal("Sabre Duplo", 30, permitidos, 25, 40));
        stock.add(new Pocao("Bacta Tank", 25, permitidos, "Cura completa", 1, 100, 0));

        return stock;
    }

    public static ArrayList<Inimigo> instanciarInimigos() {
        ArrayList<Inimigo> inimigos = new ArrayList<>();

        // Sith
        inimigos.add(new Sith("Darth Malgus", 100, 100, 20, 3, 15, 25, 18, 12, 25));
        inimigos.add(new Sith("Darth Bane", 120, 120, 22, 4, 18, 30, 20, 15, 30));

        // Stormtroopers
        inimigos.add(new Stormtrooper("Captain Phasma", 60, 60, 12, 1, 8, 10, 10, 8));
        inimigos.add(new Stormtrooper("FN-2199", 65, 65, 14, 2, 10, 12, 12, 10));

        // Separatists
        inimigos.add(new Separatist("Count Dooku", 110, 110, 25, 4, 20, 35, 22, 18, 10));
        inimigos.add(new Separatist("General Grievous", 80, 80, 16, 2, 12, 18, 15, 12, 8));

        return inimigos;
    }

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

    public static void main(String[] args) {
        Audio.playMusic("src/AudioFiles/Star Wars Main Theme.wav");
        Scanner sc = new Scanner(System.in);
        boolean jogar = true;

        mostrarIntroducao();

        while (jogar) {
            Heroi heroi = criarPersonagem();
            guerraDasGalaxias(heroi);

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
