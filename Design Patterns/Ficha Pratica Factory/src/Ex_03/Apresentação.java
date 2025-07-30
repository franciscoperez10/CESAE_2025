package Ex_03;

public class Apresentação extends Document {
    public Apresentação(String autor, String nome, String tipoDocumento) {
        super(autor, nome, tipoDocumento);
    }

    public void open() {
        System.out.println("\nA abrir o documento de " + super.tipoDocumento + " " + super.nome + super.tipoDocumento + ".ppt");
    }

    public void save() {
        System.out.println("\n Alterações do " + super.autorDocumento + "gravadas.");
    }

    public void close() {
        System.out.println("\nA fechar o documento de " + super.tipoDocumento + ".");

    }
}

