package Ex_02;

public abstract class Taco {
    protected String descricao;


    public Taco(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract void prepare();

    public abstract void bake();

    public abstract void box();

}
