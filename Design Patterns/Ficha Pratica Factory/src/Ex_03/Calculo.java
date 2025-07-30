package Ex_03;

public class Calculo extends Document {
    public Calculo(String autor, String nome, String tipoDocumento) {
        super(autor, nome, tipoDocumento);
    }

    public void open() {
        System.out.println("\nA abrir o documento de " + super.tipoDocumento + " " + super.nome + super.tipoDocumento + ".csv");
    }

    public void save() {
        System.out.println("\n Alterações do " + super.autorDocumento + "gravadas.");
    }

    public void close() {
        System.out.println("\nA fechar o documento de " + super.tipoDocumento + ".");

    }
}

