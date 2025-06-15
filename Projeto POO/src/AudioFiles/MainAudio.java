package AudioFiles;

import static java.lang.Thread.sleep;
import AudioFiles.Audio;


public class MainAudio {
    public static void main(String[] args) throws InterruptedException {
        Audio.playMusic("AudioFiles/Star Wars Main Theme.wav");

        sleep(3000);

        Audio.playMusic("AudioFiles/Star Wars Main Theme.wav");

        sleep(3000);

        System.out.println("Obrigado");
    }
}
