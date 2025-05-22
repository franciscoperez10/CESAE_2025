package FichaPratica03;

public class Ex07 {

    public static void main(String[] args) {

        int a, b, somatorio;

        a = 1;
        b = 100;
        somatorio = 0;

        while (a <= b) {

            System.out.println(a);
            somatorio = somatorio + a;
            a = a + 1;
        }

        System.out.println("Somatório: " + somatorio);
    }
}
