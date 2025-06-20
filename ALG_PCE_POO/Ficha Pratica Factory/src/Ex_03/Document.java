package Ex_03;

public abstract class Document {

    protected String autorDocumento;
    protected String nome;
    protected String tipoDocumento;

    public Document(String autorDocumento, String nome, String tipoDocumento) {
        this.autorDocumento = autorDocumento;
        this.nome = nome;
        this.tipoDocumento = tipoDocumento;
    }

    public String getAutorDocumento() {
        return autorDocumento;
    }

    public void setAutorDocumento(String autorDocumento) {
        this.autorDocumento = autorDocumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public abstract void open();

    public abstract void save();

    public abstract void close();
}
