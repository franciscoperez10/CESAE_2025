package Ex_01;

import java.util.ArrayList;

public class MusicPlayer {
    private String criador;
    private ArrayList<Musica> programacaoMusical;

    public MusicPlayer(String criador) {
        this.criador = criador;
        this.programacaoMusical = new ArrayList<Musica>();
    }

    public void adicionarMusica(Musica musicaNova) {
        this.programacaoMusical.add(musicaNova);
    }

    public void removerMusica(int indiceRemover) {
        this.programacaoMusical.remove(indiceRemover);
    }

    public void trocarMusicas(int indice1, int indice2) {

        Musica m1 = this.programacaoMusical.get(indice1);
        Musica m2 = this.programacaoMusical.get(indice2);

        this.programacaoMusical.set(indice1, m2);
        this.programacaoMusical.set(indice2, m1);
    }

    public void limparProgramacao(){
        this.programacaoMusical.clear();
    }

}