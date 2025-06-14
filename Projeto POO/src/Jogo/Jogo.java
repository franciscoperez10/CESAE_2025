package Jogo;

import Entidades.*;
import Itens.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public static void mostrarIntroducao() {
        System.out.println("===================================================");
        System.out.println("              BEM-VINDO À GUERRA DAS GALÁXIAS      ");
        System.out.println("===================================================");
        System.out.println("Neste RPG, assumes o papel de um herói numa galáxia em guerra.");
        System.out.println("O teu objetivo é atravessar um labirinto perigoso, derrotar inimigos,");
        System.out.println("fazer escolhas estratégicas e chegar ao fim da aventura com vida.");
        System.out.println();
        System.out.println(">>> COMO JOGAR <<<");
        System.out.println("- Escolhe o tipo de herói: Jedi (defensivo), Rebel (versátil) ou Mandalorian (ofensivo).");
        System.out.println("- Escolhe a dificuldade: Fácil (300 pontos, 20 ouro) ou Difícil (220 pontos, 15 ouro).");
        System.out.println("- Distribui os pontos de criação entre VIDA (1 ponto = 1 vida) e FORÇA (5 pontos = 1 força).");
        System.out.println("- Compra armas, poções e consumíveis na loja do vendedor, se quiseres.");
        System.out.println("- Avança pelas salas do labirinto, enfrenta inimigos, armadilhas e toma decisões.");
        System.out.println("- Usa poções para recuperar vida ou aumentar força após cada sala.");
        System.out.println("- O combate é por turnos e cada classe tem regras especiais de ataque.");
        System.out.println("- Podes ganhar o jogo chegando ao fim do labirinto, ou perder se a tua vida chegar a zero.");
        System.out.println();
        System.out.println(">>> REGRAS PRINCIPAIS <<<");
        System.out.println("1. Cada combate termina quando um dos lados fica sem vida.");
        System.out.println("2. Só podes usar o ataque especial uma vez por combate.");
        System.out.println("3. O vendedor só mostra 10 itens aleatórios de cada vez.");
        System.out.println("4. Se tentares comprar sem ouro suficiente ou um item não permitido, a compra falha.");
        System.out.println("5. Se usares uma poção de vida que excede o teu máximo, só curas até ao máximo e és avisado.");
        System.out.println("6. Podes tentar jogar novamente ou criar nova personagem após perder.");
        System.out.println();
        System.out.println("Boa sorte, herói! Que a Força esteja contigo.");
        System.out.println("===================================================");
        System.out.println();
    }


    public static Heroi criarPersonagem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** BEM-VINDO À GUERRA DAS GALÁXIAS! *****");
        System.out.println("Vamos começar por escolher a tua personagem");
        System.out.println("Escolhe o herói com que vais explorar a galáxia: ");
        System.out.println("1 - Jedi");
        System.out.println("2 - Rebel");
        System.out.println("3 - Mandalorian");

        int escolhaHeroi = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolhe a dificuldade:");
        System.out.println("1 - Fácil (300 pontos de criação, 20 ouro)");
        System.out.println("2 - Difícil (220 pontos de criação, 15 ouro)");
        int escolhaDificuldade = sc.nextInt();
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
            System.out.println("Pontos de criação restantes: " + pontosCriacao);
            System.out.println("Quantos pontos quer atribuir a VIDA? (1 ponto de criação = 1 vida)");
            int pontosVida = sc.nextInt();
            System.out.println("Quantos pontos quer atribuir a FORÇA? (5 pontos de criação = 1 força)");
            int pontosForca = sc.nextInt();

            int custo = pontosVida + (pontosForca * 5);
            if (custo > pontosCriacao) {
                System.out.println("Distribuição inválida! Tente novamente.");
            } else {
                vida += pontosVida;
                forca += pontosForca;
                pontosCriacao -= custo;
            }
        }

        System.out.print("Escolha o nome do seu herói: ");
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
                System.out.println("Classe inválida. A criar Jedi por defeito.");
                heroi = new Jedi(nome, vida, vida, forca, 1, 10, ouro, null, new ArrayList<>(), "Poder da Força", 0, 0, 0, 0);
        }

        System.out.println("Herói criado com sucesso!");
        heroi.mostrarDetalhes();
        return heroi;
    }

    public static void guerraDasGalaxias(Heroi heroi) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo à Guerra das Galáxias!");
        System.out.println("Há muito tempo, numa galáxia muito, muito distante, iniciou-se uma guerra entre duas classes de guerreiros: os membros da Ordem Jedi, e os sombrios Sith.");
        System.out.println("O teu objetivo é, escolhendo um dos membros aliados dos Jedi: Jedi, Rebel ou Mandalorian, enfrentar os teus inimigos, percorrendo um perigoso labirinto.");

        // Instanciar itens e vendedor
        ArrayList<ItemHeroi> stock = instanciarItens();
        Vendedor vendedor = new Vendedor(stock, "Merchant");
        vendedor.imprimirLoja();
        boolean comprar = true;
        while (comprar) {
            System.out.println("Escolhe o item que desejas comprar, ou pressiona '0' para avançar sem comprar:");
            int escolherItem = sc.nextInt();
            if (escolherItem == 0) {
                comprar = false;
            } else {
                vendedor.vender(heroi, escolherItem - 1);
            }
        }

        // Instanciar inimigos e salas
        ArrayList<Inimigo> inimigos = instanciarInimigos();
        ArrayList<String> salas = instanciarSalas();

        int salaAtual = 0;
        Random random = new Random();
        while (salaAtual < salas.size()) {
            System.out.println("\nEstás na sala: " + salas.get(salaAtual));

            int evento = random.nextInt(100);

            if (evento < 40) {
                // Combate
                Inimigo inimigo = inimigos.get(random.nextInt(inimigos.size()));
                System.out.println("Apareceu um inimigo! Um " + inimigo.getNome());
                boolean ganhar = heroi.atacar(inimigo);
                if (!ganhar) {
                    System.out.println("Perdeste! Queres jogar novamente?");
                    return;
                }
            } else if (evento < 60) {
                // Vendedor
                System.out.println("Regressaste ao vendedor!");
                vendedor.imprimirLoja();
                boolean comprarSala = true;
                while (comprarSala) {
                    System.out.println("Escolhe o item que desejas comprar, ou pressiona '0' para avançar:");
                    int escolherItemSala = sc.nextInt();
                    if (escolherItemSala == 0) {
                        comprarSala = false;
                    } else {
                        vendedor.vender(heroi, escolherItemSala - 1);
                    }
                }
            } else if (evento < 80) {
                // Armadilha
                int dano = random.nextInt(30) + 1;
                heroi.setVidaAtual(heroi.getVidaAtual() - dano);
                System.out.println("Caíste numa armadilha! Perdeste " + dano + " pontos de vida.");
                if (heroi.getVidaAtual() <= 0) {
                    System.out.println("Foste derrotado por uma armadilha! Queres jogar novamente?");
                    return;
                }
            } else {
                // Encontrou poção
                System.out.println("Encontraste uma poção de vida!");
                heroi.getInventario().add(new Pocao("Poção Encontrada", 0, null, "Cura 15 HP", 1, 15, 0));
            }

            // Permitir uso de poções após cada sala
            heroi.usarPocao();

            // Escolha de avançar para próxima sala
            if (salaAtual < salas.size() - 1) {
                System.out.println("Queres avançar para a próxima sala? (1=Sim, 0=Não)");
                int avancar = sc.nextInt();
                if (avancar == 1) {
                    salaAtual++;
                } else {
                    System.out.println("A aventura termina aqui.");
                    break;
                }
            } else {
                System.out.println("Parabéns! Chegaste ao fim do labirinto e venceste o jogo!");
                break;
            }
        }
        sc.close();
    }

    public static ArrayList<ItemHeroi> instanciarItens() {
        ArrayList<ItemHeroi> stock = new ArrayList<>();
        ArrayList<ClassesPermitidas> todas = new ArrayList<>();
        todas.add(ClassesPermitidas.JEDI);
        todas.add(ClassesPermitidas.REBEL);
        todas.add(ClassesPermitidas.MANDALORIAN);

        // Armas principais
        stock.add(new ArmaPrincipal("Sabre de Luz", 25, todas, 20, 35));
        stock.add(new ArmaPrincipal("Blaster", 15, todas, 12, 22));
        stock.add(new ArmaPrincipal("Rifle de Precisão", 20, todas, 15, 28));
        stock.add(new ArmaPrincipal("Vibroblade", 18, todas, 14, 25));

        // Poções
        stock.add(new Pocao("Poção de Vida", 10, todas, "Cura 25 HP", 1, 25, 0));
        stock.add(new Pocao("Poção de Força", 12, todas, "Aumenta força em 5", 1, 0, 5));
        stock.add(new Pocao("Super Poção", 20, todas, "Cura 50 HP e aumenta força", 1, 50, 3));
        stock.add(new Pocao("Elixir da Vida", 15, todas, "Cura 35 HP", 1, 35, 0));

        // Consumíveis de combate
        stock.add(new ConsumivelCombate("Granada Térmica", 8, todas, "Dano explosivo", 1, 25));
        stock.add(new ConsumivelCombate("Explosivo", 12, todas, "Grande dano instantâneo", 1, 35));
        stock.add(new ConsumivelCombate("Bomba de Fumo", 6, todas, "Dano moderado", 1, 15));
        stock.add(new ConsumivelCombate("Detonador", 10, todas, "Dano médio", 1, 20));

        // Itens adicionais
        stock.add(new ArmaPrincipal("Sabre Duplo", 30, todas, 25, 40));
        stock.add(new Pocao("Bacta Tank", 25, todas, "Cura completa", 1, 100, 0));

        return stock;
    }

    public static ArrayList<Inimigo> instanciarInimigos() {
        ArrayList<Inimigo> inimigos = new ArrayList<>();

        // Sith
        inimigos.add(new Sith("Darth Malgus", 100, 100, 20, 3, 15, 25, 18, 12, 25));
        inimigos.add(new Sith("Darth Revan", 120, 120, 22, 4, 18, 30, 20, 15, 30));

        // Stormtroopers
        inimigos.add(new Stormtrooper("TK-421", 60, 60, 12, 1, 8, 10, 10, 8));
        inimigos.add(new Stormtrooper("TK-876", 65, 65, 14, 2, 10, 12, 12, 10));

        // Separatists
        inimigos.add(new Separatist("General Grievous", 110, 110, 25, 4, 20, 35, 22, 18, 10));
        inimigos.add(new Separatist("Comandante Droide", 80, 80, 16, 2, 12, 18, 15, 12, 8));

        return inimigos;
    }

    public static ArrayList<String> instanciarSalas() {
        ArrayList<String> salas = new ArrayList<>();
        salas.add("Entrada do Labirinto");
        salas.add("Vale dos Mortos");
        salas.add("Montanha das Virtudes");
        salas.add("Caverna Sombria");
        salas.add("Templo Perdido");
        salas.add("Sala do Mercador");
        salas.add("Câmara dos Cristais");
        salas.add("Corredor Final");
        return salas;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jogar = true;

        mostrarIntroducao();

        while (jogar) {
            Heroi heroi = criarPersonagem();
            guerraDasGalaxias(heroi);

            System.out.println("Queres jogar novamente?");
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
