package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;
import java.util.Scanner;

public class Rebel extends Heroi {
    // Atributos específicos do Rebel
    protected int ataque;
    protected int defesa;

    /**
     * Construtor do Rebel
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
     * @param ataque
     */

    public Rebel(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia, int ataque) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa, ouro, armaPrincipal, inventario, habilidadeEspecial, experiencia);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    /**
     * Método de ataque ao Inimigo, pelo Rebel
     * O Rebel ataca primeiro
     * @param inimigo que se vai enfrentar
     * @return true se o Rebel ganhar, caso contrário, false
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

            // Menu de ataque do herói
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

            // O inimigo ataca (força total)
            int danoInimigo = inimigo.getForca();
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
     * Método de Defesa do Rebel
     */
    @Override
    public void defender() {

        System.out.println(nome + "executa uma posição defensiva!");
        this.defesa += 20;
    }

    @Override
    public void usarPocao() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Consumivel> pocoes = new ArrayList<>();
        for (Consumivel consumiveis : this.inventario) {
            if (consumiveis instanceof Itens.Pocao) {
                pocoes.add(consumiveis);
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

        this.forca += pocao.getAumentoDeForca();
        System.out.println("Usaste a poção " + pocao.getNome() + ". Vida: " + this.vidaAtual + "/" + this.vidaMax + " | Força: " + this.forca);
        this.inventario.remove(pocao);
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa " + habilidadeEspecial + "!");
    }

    @Override
    public void usarItem(ItemHeroi item) {
        System.out.println(nome + " usa o item: " + item.getNome());
    }

    public void mudarArma() {
        System.out.println(nome + " troca de arma!");
    }

    public void reforcarDefesa() {
        System.out.println(nome + " reforça a sua posição defensiva!");
    }

    public void usarGranada() {
        System.out.println(nome + " atira uma granada!");
    }

    /**
     * Método que imprime os Detalhes do Rebel, após cada jogada
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Rebel: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia + " | Ataque: " + ataque + " | Defesa: " + defesa);
    }

}
