package Ex_06;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar 6 atletas
        Atleta atleta1 = new Atleta("João Silva", 1, "Natação", 75.5, "Portugal", 1.80);
        Atleta atleta2 = new Atleta("Maria Santos", 2, "Atletismo", 60.0, "Brasil", 1.70);
        Atleta atleta3 = new Atleta("Pedro Costa", 3, "Futebol", 80.0, "Portugal", 1.85);
        Atleta atleta4 = new Atleta("Francisco Perez", 4, "Ténis", 80, "Portugal", 1.79);
        Atleta atleta5 = new Atleta("Patricia Carvalho", 5, "Basebol", 60, "Moçambique", 1.65);
        Atleta atleta6 = new Atleta("Joana Silva", 6, "Basquetebol", 55, "EUA", 1.80);

        // 2. Instanciar duas competições
        Competicao comp1 = new Competicao("Olimpíadas", "Portugal", 10);
        Competicao comp2 = new Competicao("Mundial", "Brasil", 10);

        // 3. Adicionar 2 atletas a cada competição (ajusta conforme o que pede)
        comp1.inscreverAtleta(atleta1);
        comp1.inscreverAtleta(atleta3);
        comp2.inscreverAtleta(atleta2);
        // ... adiciona mais conforme necessário

        // 4. Listar participantes
        comp1.listarParticipantes();
        comp2.listarParticipantes();

        // 5. Atletas da casa
        comp1.atletasDaCasa();
        comp2.atletasDaCasa();
    }
}
