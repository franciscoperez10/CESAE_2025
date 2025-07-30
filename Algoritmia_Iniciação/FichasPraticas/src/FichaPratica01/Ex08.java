package FichaPratica01;

import java.util.Scanner;

public class Ex08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int horas, minutos, segundos;

        System.out.print("Introduza minutos da música 1: ");
        minutos = input.nextInt();

        System.out.print("Introduza segundos da música 1: ");
        segundos = input.nextInt();

        System.out.print("Introduza minutos da música 2: ");
        minutos = minutos + input.nextInt();

        System.out.print("Introduza segundos da música 2: ");
        segundos = segundos + input.nextInt();

        System.out.print("Introduza minutos da música 3: ");
        minutos = minutos + input.nextInt();

        System.out.print("Introduza segundos da música 3: ");
        segundos = segundos + input.nextInt();

        System.out.print("Introduza minutos da música 4: ");
        minutos = minutos + input.nextInt();

        System.out.print("Introduza segundos da música 4: ");
        segundos = segundos + input.nextInt();

        System.out.print("Introduza minutos da música 5: ");
        minutos = minutos + input.nextInt();

        System.out.print("Introduza segundos da música 5: ");
        segundos = segundos + input.nextInt();

        horas = minutos / 60;
        minutos = (segundos / 60) + minutos % 60;
        segundos = segundos % 60;

        System.out.println("Total do Álbum: " + horas + "h " + minutos + "m " + segundos + "s ");
    }
}
