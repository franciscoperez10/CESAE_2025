package Ex_01;

public class Main {
    public static void main(String[] args) {

        Musica musica1 = new Musica("The Scientist", "Rock Alternativo", "Coldplay", 260);
        Musica musica2 = new Musica("Bohemian Rapsody", "Rock", "Queen", 359);
        Musica musica3 = new Musica("Mestre da Culinária", "Heavy Metal", "Quim Barreiros", 233);

        MusicPlayer mp = new MusicPlayer("Vitor");
        mp.adicionarMusica(musica1);
        mp.adicionarMusica(musica2);
        mp.adicionarMusica(musica3);


    }
}