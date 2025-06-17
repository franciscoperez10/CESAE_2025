package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ItemHeroi;

import java.util.ArrayList;

/**
 * Classe abstrata, que representa um Herói jogável
 * Herda de Personagem
 * As subclasses de Herói vão implementar o método atacar()
 * As subclasses de Herói vão ter métodos específicos
 */
public abstract class Heroi extends Personagem {

    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;
    protected String habilidadeEspecial;
    protected int experiencia;

    /**
     * Construtor que permite instanciar um Herói
     *
     * @param nome
     * @param vidaMax
     * @param vidaAtual
     * @param forca
     * @param nivel
     * @param defesa
     * @param ouro
     * @param armaPrincipal
     * @param inventario         inicial dos itens consumíveis
     * @param habilidadeEspecial
     * @param experiencia
     */
    public Heroi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int defesa, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario, String habilidadeEspecial, int experiencia) {
        super(nome, vidaMax, vidaAtual, forca, nivel, defesa);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = inventario;
        this.habilidadeEspecial = habilidadeEspecial;
        this.experiencia = experiencia;
    }

    // Getter para o nível do Herói
    @Override
    public int getNivel() {
        return nivel;
    }

    // Setter para o nível do Herói
    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // Getter e Setter para a quantidade de Ouro que vai ser usada no jogo

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Consumivel> inventario) {
        this.inventario = inventario;
    }

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Método abstrato que faz com que os Heróis ataquem durante o jogo
     *
     * @param inimigo que se vai enfrentar
     * @return true se o heróir vencer, caso contrário, false
     */
    public boolean atacar(Inimigo inimigo) {
        if (this.getVidaAtual() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método abstrato que permite defesa. Não usado no resultado final.
     */
    public abstract void defender();

    /**
     * Método que permite a utilização de poções
     */
    public abstract void usarPocao();


    /**
     * Método abstrato para usar a habilidade especial do herói.
     */
    public abstract void usarHabilidadeEspecial();

    /**
     * Método para ganhar atualizar a experiência do Herói
     * Verifica se sobe de nível, através de Pontos de Experiência a cada jogada (XP)
     *
     * @param xp Pontos de Experiência ganhos
     */
    public void ganharXP(int xp) {
        this.experiencia += xp;
        System.out.println(nome + " ganhou " + xp + " pontos de experiência. Tem agora um total de  " + experiencia + ".");
        if (this.experiencia >= experienciaParaProximoNivel()) {
            subirNivel();
        }
    }

    /**
     * Método para ganhar Pontos de Experiência a cada jogada (XP)
     */
    public int experienciaParaProximoNivel() {
        return this.nivel * 10;
    }

    /**
     * Método para subir de nível.
     * Método para aumentar atributos. Cura, mas só na vida máxima, não totalmente.
     */
    public void subirNivel() {
        this.nivel++;
        this.experiencia = 0;
        this.vidaMax += 10;
        this.forca += 1;
        this.defesa += 1;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }

    /**
     * Método que imprime o "estado" do Herói no final de cada jogada
     */
    public void mostrarResumoHeroi() {
        System.out.print(
                getClass().getSimpleName() + ": " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia
        );
        System.out.println();
    }

    /**
     * Método abstrato para usar um item do inventário. Não usado no resultado final
     *
     * @param item
     */
    public abstract void usarItem(ItemHeroi item);

    /**
     * Método para mostrar os detalhes do Herói
     */
    @Override
    public void mostrarDetalhes() {
        System.out.print("Herói: " + nome + " | Nível: " + nivel + " | Vida: " + vidaAtual + "/" + vidaMax + " | Força: " + forca + " | Defesa: " + defesa + " | Ouro: " + ouro + " | Experiência: " + experiencia);
        System.out.print(" | Arma Principal: ");
        if (armaPrincipal != null) {
            System.out.print(armaPrincipal.getNome());
        } else {
            System.out.print("Nenhuma");
        }
        System.out.println();
    }


}

