package Itens;
/**
 * Classe que representa uma arma principal que pode ser usada por heróis.
 * Herda da classe ItemHeroi e adiciona atributos para ataque normal e ataque especial.
 */

import Entidades.HeroisPermitidos;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    protected int ataque;
    protected int ataqueEspecial;

    /**
     * Construtor da ArmaPrincipal
     *
     * @param nome
     * @param precoMoedasOuro
     * @param classesPermitidas
     * @param ataque
     * @param ataqueEspecial
     */
    public ArmaPrincipal(String nome, int precoMoedasOuro, ArrayList<HeroisPermitidos> classesPermitidas, int ataque, int ataqueEspecial) {
        super(nome, precoMoedasOuro, classesPermitidas);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    /**
     * Mostra as especificações detalhadas da arma na consola, nomeadamente, nome, preço, ataque, ataque especial e classes permitidas.
     */
    @Override
    public void mostrarDetalhes() {
        System.out.print("Arma: " + nome + " | Preço: " + precoMoedasOuro + " | Ataque: " + ataque + " | Ataque Especial: " + ataqueEspecial + " | Classes permitidas: ");
        for (HeroisPermitidos heroi : classesPermitidas) {
            System.out.print(heroi + " ");
        }
        System.out.println();
    }

}
