package Ex_03;

public class Texto extends Document {
    public Texto(String autor, String nome, String tipoDocumento) {
        super(autor, nome, tipoDocumento);
    }

    public void open() {
        System.out.println("\nA abrir o documento de " + super.tipoDocumento + " " + super.nome + super.tipoDocumento + ".txt" );
    }

    public void save() {
        System.out.println("\nAlterações do " + super.autorDocumento + " gravadas.");
    }

    public void close() {
        System.out.println("\nA fechar o documento de " + super.tipoDocumento + ".");

    }
}

