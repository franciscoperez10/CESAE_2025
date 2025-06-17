package Entidades;

import Itens.ItemHeroi;
import Itens.ArmaPrincipal;
import Itens.Consumivel;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {

    private ArrayList<ItemHeroi> loja;
    private String nome;

    public Vendedor(ArrayList<ItemHeroi> loja, String nome) {
        this.loja = loja;
        this.nome = nome;
    }

    public ArrayList<ItemHeroi> imprimirLoja() {
        ArrayList<ItemHeroi> itensVisiveis = new ArrayList<>();
        Random random = new Random();
        ArrayList<Integer> indicesUsados = new ArrayList<>();

        int maximoItens = 10;
        if (loja.size() < 10) {
            maximoItens = loja.size();
        }
        while (itensVisiveis.size() < maximoItens) {
            int indiceAleatorio = random.nextInt(loja.size());
            if (!indicesUsados.contains(indiceAleatorio)) {
                itensVisiveis.add(loja.get(indiceAleatorio));
                indicesUsados.add(indiceAleatorio);
            }
        }


        System.out.println("\n***** Itens Disponíveis na Loja: *****");

        for (int i = 0; i < itensVisiveis.size(); i++) {
            ItemHeroi item = itensVisiveis.get(i);
            System.out.println((i + 1) + " - " + item.getNome() + " (Preço: " + item.getPrecoMoedasOuro() + " ouro)");
        }
        return itensVisiveis;
    }


    public void vender(Heroi heroi, ItemHeroi item) {
        if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
            System.out.println("Ouro insuficiente para comprar este item.");
            return;
        }
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
        heroi.setOuro(heroi.getOuro() - item.getPrecoMoedasOuro());
        if (item instanceof ArmaPrincipal) {
            heroi.setArmaPrincipal((ArmaPrincipal) item);
            System.out.println("Arma principal trocada com sucesso!");
        } else if (item instanceof Consumivel) {
            heroi.getInventario().add((Consumivel) item);
            System.out.println("Item adicionado ao inventário!");
        }

        loja.remove(item);
        System.out.println("\nO item" + " " + item.getNome() + " já não pode ser comprado");
        System.out.println("\nOuro disponível após a compra: " + heroi.getOuro());
    }
}
