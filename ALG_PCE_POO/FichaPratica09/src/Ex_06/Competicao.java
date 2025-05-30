package Ex_06;

public class Competicao {
    private String nomeDaCompeticao;
    private String pais;
    private Atleta[] atletasParticipantes;

    public Competicao(String nomeDaCompeticao, String pais, int maxInscritos) {
        this.nomeDaCompeticao = nomeDaCompeticao;
        this.pais = pais;
        this.atletasParticipantes = new Atleta[maxInscritos];
    }

    public void inscreverAtleta(Atleta novoAtleta) {
        for (int i = 0; i < this.atletasParticipantes.length; i++) {
            if (this.atletasParticipantes[i] == null) {
                this.atletasParticipantes[i] = novoAtleta;
                return; // Sai do método após inscrever
            }
        }
    }

    public void listarParticipantes() {
        System.out.println("\n________________________________________________________");
        System.out.println("Participantes da " + this.nomeDaCompeticao + ":");
        for (int i = 0; i < this.atletasParticipantes.length; i++) {
            if (this.atletasParticipantes[i] != null) {
                // Se quiseres imprimir só o nome:
                System.out.println(this.atletasParticipantes[i].getNome());
                // Se quiseres imprimir todos os dados, implementa toString() em Atleta
            }
        }
        System.out.println("________________________________________________________");
    }

    public void atletasDaCasa() {
        System.out.println("\n________________ Atletas da casa (" + this.pais + ") ________________");
        for (int i = 0; i < this.atletasParticipantes.length; i++) {
            if (this.atletasParticipantes[i] != null && this.atletasParticipantes[i].getPaisDeOrigem().equals(this.pais)) {
                System.out.println(this.atletasParticipantes[i].getNome());
                // Ou, se implementares toString(): System.out.println(this.atletasParticipantes[i]);
            }
        }
        System.out.println("________________________________________________________");
    }

    // Getters
    public String getNomeDaCompeticao() {
        return nomeDaCompeticao;
    }

    public String getPais() {
        return pais;
    }

    public Atleta[] getAtletasParticipantes() {
        return atletasParticipantes;
    }
}
