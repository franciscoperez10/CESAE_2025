package Itens;


import Entidades.ClassesPermitidas;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    protected int ataque;
    protected int ataqueEspecial;

    public ArmaPrincipal(String nome, int precoMoedasOuro, ArrayList<ClassesPermitidas> classesPermitidas, int ataque, int ataqueEspecial) {
        super(nome, precoMoedasOuro, classesPermitidas);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }
}
