package Ex_07;

public class Aluno {

    private String nome;
    private int idade;
    private String email;
    private String curso;
    private double media;


    public Aluno(String nome, int idade, String email, String curso, double media) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.curso = curso;
        this.media = media;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }


    public void felizAniversario() {
        this.idade++;
    }

    public boolean situacaoAprovacao() {

        if (this.media >= 9.5)
        return true;
        else return false;

    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Email: " + email);
        System.out.println("Curso: " + curso);
        System.out.println("Media: " + media);

    }
}
