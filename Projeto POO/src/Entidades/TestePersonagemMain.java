package Entidades;

public class TestePersonagemMain {
    public static void main(String[] args) {

        PersonagemTeste p1 = new PersonagemTeste("Luke", 100, 100, 20, 1, 10);


        p1.mostrarDetalhes();


        p1.receberDano(30);
        p1.mostrarDetalhes();


        p1.curar(50);
        p1.mostrarDetalhes();


        System.out.println("Está vivo? " + p1.temVida());


        p1.receberDano(200);
        p1.mostrarDetalhes();
        System.out.println("Está vivo? " + p1.temVida());
    }
}
