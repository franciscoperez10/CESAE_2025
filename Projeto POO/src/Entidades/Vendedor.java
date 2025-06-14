package Entidades;

import Itens.ItemHeroi;

import java.util.ArrayList;
import java.util.Random;

public class Vendedor {

    private ArrayList<ItemHeroi> loja;
    private String nome;

    public Vendedor(ArrayList<ItemHeroi> loja, String nome) {
        this.loja = loja;
        this.nome = nome;
    }

    public void imprimirLoja() {
        System.out.println("Itens que estão disponíveis na loja:");
        int maximoItensLoja = Math.min(10, loja.size());
        ArrayList<ItemHeroi> novo = new ArrayList<>(loja);
        Random random = new Random();

        for (int i = 0; i < maximoItensLoja; i++) {
            int posicao = random.nextInt(novo.size());
            System.out.println((i + 1) + " - ");
            novo.get(posicao).mostrarDetalhes();
            novo.remove(posicao);
        }
    }

    public void vender(Heroi heroi, int indiceItem) {
        if (indiceItem < 0 || indiceItem >= loja.size()) {
            System.out.println("Item inválido.");
            return;
        }
        ItemHeroi item = loja.get(indiceItem);

        if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
            System.out.println("Ouro insuficiente para comprar este item.");
            return;
        }

        boolean permitido = false;
        for (Entidades.ClassesPermitidas c : item.getClassesPermitidas()) {
            if (c.name().equalsIgnoreCase(heroi.getClass().getSimpleName())) {
                permitido = true;
                break;
            }
        }
        if (!permitido) {
            System.out.println("Este item não pode ser usado pelo seu tipo de herói.");
            return;
        }

        heroi.setOuro(heroi.getOuro() - item.getPrecoMoedasOuro());
        if (item instanceof Itens.ArmaPrincipal) {
            heroi.setArmaPrincipal((Itens.ArmaPrincipal) item);
            System.out.println("Arma principal trocada com sucesso!");
        } else if (item instanceof Itens.Consumivel) {
            heroi.getInventario().add((Itens.Consumivel) item);
            System.out.println("Item adicionado ao inventário!");
        }


    }


}
