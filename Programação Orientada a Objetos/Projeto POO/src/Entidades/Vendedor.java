package Entidades;

import Itens.ItemHeroi;
import Itens.ArmaPrincipal;
import Itens.Consumivel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que representa o Vendedor do jogo.
 * A classe permite por gerir o stock de itens disponíveis para venda e mostrar os itens ao jogador.
 * Permite ainda realizar as transações de compra, garantindo que as regras de uso e ouro são respeitadas.
 */

public class Vendedor {
    // Lista de itens disponíveis na loja do vendedor (stock)
    private ArrayList<ItemHeroi> loja;
    private String nome;

    /**
     * Construtor do Vendedor.
     * Inicializa o stock de itens e nome do vendedor.
     *
     * @param loja Lista de itens disponíveis para venda
     * @param nome Nome do vendedor
     */
    public Vendedor(ArrayList<ItemHeroi> loja, String nome) {
        this.loja = loja;
        this.nome = nome;
    }

    /**
     * Mostra até 10 itens aleatórios disponíveis na loja, sem repetições.
     * Imprime na consola o nome e preço de cada item visível.
     *
     * @return Lista dos itens visíveis nesta ronda de compras (para seleção pelo jogador)
     */
    public ArrayList<ItemHeroi> imprimirLoja() {
        ArrayList<ItemHeroi> itensVisiveis = new ArrayList<>();
        Random random = new Random();
        ArrayList<Integer> indicesUsados = new ArrayList<>();

        // Define o número máximo de itens a mostrar (10 ou menos se o stock for menor)
        int maximoItens = Math.min(10, loja.size());

        // Seleciona itens aleatórios sem repetições
        while (itensVisiveis.size() < maximoItens) {
            int indiceAleatorio = random.nextInt(loja.size());
            if (!indicesUsados.contains(indiceAleatorio)) {
                itensVisiveis.add(loja.get(indiceAleatorio));
                indicesUsados.add(indiceAleatorio);
            }
        }

        // Imprime os detalhes completos dos itens disponíveis na loja
        System.out.println("\n***** Itens Disponíveis na Loja: *****");
        for (int i = 0; i < itensVisiveis.size(); i++) {
            ItemHeroi item = itensVisiveis.get(i);
            System.out.print((i + 1) + " - ");
            item.mostrarDetalhes(); // Mostra todos os detalhes do item (nome, preço, efeitos, classes, etc.)
        }
        return itensVisiveis;
    }

    /**
     * Permite efetuar a venda de um item ao herói, verificando se há ouro suficiente e se o item é permitido na sua classe.
     * Atualiza o inventário do herói e remove o item do stock da loja para não ser vendido novamente.
     * Imprime mensagens sobre o sucesso ou falha da compra.
     *
     * @param heroi Herói que está a comprar o item
     * @param item  Item a ser comprado
     */
    public void vender(Heroi heroi, ItemHeroi item) {
        if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
            System.out.println("Ouro insuficiente para comprar este item.");
            return;
        }
        // Verifica se o item pode ser usado pelo tipo de herói específico
        boolean permitido = false;
        for (HeroisPermitidos classePermitida : item.getClassesPermitidas()) {
            if (classePermitida.name().equalsIgnoreCase(heroi.getClass().getSimpleName())) {
                permitido = true;
                break;
            }
        }
        if (!permitido) {
            System.out.println("Este item não pode ser usado pelo seu tipo de herói.");
            return;
        }
        // Subtrai o ouro ao herói
        heroi.setOuro(heroi.getOuro() - item.getPrecoMoedasOuro());
        // Se for uma arma principal, fornece ao herói com a nova arma
        if (item instanceof ArmaPrincipal) {
            heroi.setArmaPrincipal((ArmaPrincipal) item);
            System.out.println("Arma principal trocada com sucesso!");
            // Se for um consumível, adiciona ao inventário
        } else if (item instanceof Consumivel) {
            heroi.getInventario().add((Consumivel) item);
            System.out.println("Item adicionado ao inventário!");
        }
        // Remove o item do stock da loja para que este não seja vendido novamente
        loja.remove(item);
        System.out.println("\nO item" + " " + item.getNome() + " já não pode ser comprado");
        System.out.println("\nOuro disponível após a compra: " + heroi.getOuro());
    }
}
