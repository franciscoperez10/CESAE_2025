package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um herói Jedi no jogo.
 * Herda de Herói e adiciona atributos específicos como combustivelJetPack, durabilidadeArmadura e slugthrowers.
 */
public class Mandalorian extends Heroi {
    // Atributos específicos do Mandalorian
    protected int combustivelJetPack;
    protected int durabilidadeArmadura;
    protected int slugthrowers;

    /**
     * Construtor do Mandalorian
     *
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     * @param armaPrincipal
     * @param inventario
     * @param habilidadeEspecial
     * @param experiencia
     * @param combustivelJetPack
     * @param durabilidadeArmadura
     * @param slugthrowers
     */
    public Mandalorian(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia, int combustivelJetPack, int durabilidadeArmadura, int slugthrowers) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro, armaPrincipal, inventario, habilidadeEspecial, experiencia);
        this.combustivelJetPack = combustivelJetPack;
        this.durabilidadeArmadura = durabilidadeArmadura;
        this.slugthrowers = slugthrowers;
    }

    /**
     * Método de ataque ao Inimigo, pelo Mandalorian
     * O Mandalorian ataca primeiro
     * Depois o inimigo ataca com 10% de dano extra.
     *
     * @param inimigo
     * @return true se o Mandalorian ganhar, caso contrário, false
     */
    @Override
    public boolean atacar(Inimigo inimigo) {
        Scanner sc = new Scanner(System.in);
        boolean ataqueEspecialUsado = false;

        while (this.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
            System.out.println("\n ***** Combate *****");
            System.out.println(this.nome + " (Vida: " + this.getVidaAtual() + "/" + this.getVidaMax() + ")");
            System.out.println(inimigo.getNome() + " (Vida: " + inimigo.getVidaAtual() + "/" + inimigo.getVidaMax() + ")");
            System.out.println("=============================");


            System.out.println("\nEscolhe o tipo de ataque:");
            System.out.println("1 - Ataque Normal");
            if (ataqueEspecialUsado) {
                System.out.println("2 - Ataque Especial (já usado)");
            } else {
                System.out.println("2 - Ataque Especial");
            }
            System.out.println("3 - Ataque Consumível");

            int escolha = sc.nextInt();
            sc.nextLine();

            int danoHeroi = this.forca;
            if (this.armaPrincipal != null) {
                danoHeroi += this.armaPrincipal.getAtaque();
            }

            if (escolha == 1) {
                System.out.println(this.nome + " ataca! Dano: " + danoHeroi);
                inimigo.receberDano(danoHeroi);
            } else if (escolha == 2) {
                if (!ataqueEspecialUsado && this.armaPrincipal != null) {
                    int danoEspecial = this.forca + this.armaPrincipal.getAtaqueEspecial();
                    System.out.println(this.nome + " usa o ataque especial! Dano: " + danoEspecial);
                    inimigo.receberDano(danoEspecial);
                    ataqueEspecialUsado = true;
                } else {
                    if (ataqueEspecialUsado) {
                        System.out.println("Ataque especial já foi usado. Ataque normal realizado.");
                    } else {
                        System.out.println("Não tens arma especial. Ataque normal realizado.");
                    }
                    inimigo.receberDano(danoHeroi);
                }
            } else if (escolha == 3) {
                ArrayList<Consumivel> consumiveisCombate = new ArrayList<>();
                for (Consumivel c : this.inventario) {
                    if (c instanceof Itens.ConsumivelCombate) {
                        consumiveisCombate.add(c);
                    }
                }
                if (consumiveisCombate.size() == 0) {
                    System.out.println("Não tens consumíveis de combate. Ataque normal realizado.");
                    inimigo.receberDano(danoHeroi);
                } else {
                    System.out.println("Consumíveis disponíveis:");
                    for (int i = 0; i < consumiveisCombate.size(); i++) {
                        System.out.println((i + 1) + " - " + consumiveisCombate.get(i).getNome() + " (Dano: " + ((Itens.ConsumivelCombate) consumiveisCombate.get(i)).getAtaqueInstantaneo() + ")");
                    }
                    System.out.println("Escolhe o número do consumível ou 0 para cancelar:");
                    int cons = sc.nextInt();
                    sc.nextLine();
                    if (cons == 0) {
                        System.out.println("Ataque consumível cancelado. Ataque normal realizado.");
                        inimigo.receberDano(danoHeroi);
                    } else if (cons > 0 && cons <= consumiveisCombate.size()) {
                        Itens.ConsumivelCombate consComb = (Itens.ConsumivelCombate) consumiveisCombate.get(cons - 1);
                        System.out.println(this.nome + " usa " + consComb.getNome() + "! Dano: " + consComb.getAtaqueInstantaneo());
                        inimigo.receberDano(consComb.getAtaqueInstantaneo());
                        this.inventario.remove(consComb);
                    } else {
                        System.out.println("Opção inválida. Ataque normal realizado.");
                        inimigo.receberDano(danoHeroi);
                    }
                }
            } else {
                System.out.println("Opção inválida. Ataque normal realizado.");
                inimigo.receberDano(danoHeroi);
            }

            if (inimigo.getVidaAtual() <= 0) {
                System.out.println("O inimigo foi derrotado!");
                int xpGanho = 10;
                this.ganharXP(xpGanho);
                this.ouro += inimigo.getOuro();
                System.out.println("Ganhaste " + xpGanho + " XP e " + inimigo.getOuro() + " ouro!");
                return true;
            }

            // O inimigo ataca (10% mais dano)
            int danoInimigo = (int) (inimigo.getForca() * 1.1);
            System.out.println(inimigo.getNome() + " ataca! Dano: " + danoInimigo);
            this.receberDano(danoInimigo);
            System.out.println("Vida atual do herói: " + this.getVidaAtual() + "/" + this.getVidaMax());

            if (this.getVidaAtual() <= 0) {
                System.out.println("Foste derrotado pelo inimigo!");
                return false;
            }
        }
        return false;
    }


    /**
     * Método que faz com que o Mandalorian reforce a sua defesa. Não usado no resultado final.
     */
    @Override
    public void defender() {
        System.out.println(nome + " usa a armadura para defender o ataque! A durabilidade restante é: " + durabilidadeArmadura);
        this.defesa += 35;
    }

    /**
     * Método que permite usar uma poção, do inventário
     */
    @Override
    public void usarPocao() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Consumivel> pocoes = new ArrayList<>();
        for (Consumivel c : this.inventario) {
            if (c instanceof Itens.Pocao) {
                pocoes.add(c);
            }
        }
        if (pocoes.size() == 0) {
            System.out.println("Não tens poções no inventário.");
            return;
        }
        System.out.println("Poções disponíveis:");
        for (int i = 0; i < pocoes.size(); i++) {
            Itens.Pocao p = (Itens.Pocao) pocoes.get(i);
            System.out.println((i + 1) + " - " + p.getNome() + " (Cura: " + p.getVidaACurar() + ", Força: " + p.getAumentoDeForca() + ")");
        }
        System.out.print("Escolhe o número da poção a usar ou 0 para cancelar: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        if (escolha == 0) {
            System.out.println("Uso de poção cancelado.");
            return;
        }
        if (escolha < 1 || escolha > pocoes.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        Itens.Pocao pocao = (Itens.Pocao) pocoes.get(escolha - 1);


        int vidaAntes = this.vidaAtual;
        int vidaACurar = pocao.getVidaACurar();
        if (vidaAntes + vidaACurar > this.vidaMax) {
            int excesso = (vidaAntes + vidaACurar) - this.vidaMax;
            System.out.println("A poção cura mais do que o máximo de vida. Vais desperdiçar " + excesso + " pontos de cura.");
            this.vidaAtual = this.vidaMax;
        } else {
            this.vidaAtual += vidaACurar;
        }
        // Aumenta força, se aplicável
        this.forca += pocao.getAumentoDeForca();
        System.out.println("Usaste a poção " + pocao.getNome() + ". Vida: " + this.vidaAtual + "/" + this.vidaMax + " | Força: " + this.forca);
        this.inventario.remove(pocao);
    }

    /**
     * Método que permite ao Mandalorian usar a sua habilidade especial. Não usado no resultado final.
     */
    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa " + habilidadeEspecial + "!");
    }

    /**
     * Método que permite ao Mandalorian usar um item concreto.
     *
     * @param item
     */
    @Override
    public void usarItem(ItemHeroi item) {
        System.out.println(nome + " usa o item: " + item.getNome());
    }

    /**
     * Método que permite ao Mandalorian usar um Jet Pack para fugir do combate. Não usado no resultado final.
     */
    public void usarJetPack() {
        if (combustivelJetPack > 0) {
            System.out.println(nome + " voa com o jetpack! Combustível restante: " + (--combustivelJetPack));
        } else {
            System.out.println(nome + " está sem combustível no jetpack!");
        }
    }

    /**
     * Método que permite ao Mandalorian usar uma arma de combate exclusiva. Não usado durante o resultado final.
     */
    public void usarSlugthrowers() {
        System.out.println(nome + " usa slugthrowers para disparar!");

    }

    /**
     * Método que permite ao Mandalorian mudar de arma durante o combate. Não usado durante o resultado final.
     */
    public void mudarArma() {
        System.out.println(nome + " troca de arma!");
    }

    /**
     * Método que permite ao Mandalorian reforçar a armadura. Não usado durante o resultado final.
     */
    public void reforcarArmadura() {
        durabilidadeArmadura += 10;
        System.out.println(nome + " reforça a armadura! A durabilidade atual é de: " + durabilidadeArmadura);
    }

    /**
     * Método que imprime os Detalhes do Mandalorian, após cada jogada.
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Mandalorian: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia + " | Combustível JetPack: " + combustivelJetPack + " | Durabilidade Armadura: " + durabilidadeArmadura + " | Slugthrowers: " + slugthrowers);
    }
}
