import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EleicaoTest {

    private Eleicao eleicoesAutarquicas;
    private Eleicao eleicoesEstudantes;
    private Candidato candidato1;
    private Candidato candidato2;
    private Candidato candidatoMenorIdade1;
    private Candidato candidatoMenorIdade2;
    private Eleitor eleitor1;
    private Eleitor eleitor2;
    private Eleitor eleitorMenorIdade1;
    private Eleitor eleitorMenorIdade2;


    @BeforeEach
    void setUp() {
        eleicoesAutarquicas = new Eleicao("Autárquicas", 18);
        eleicoesEstudantes = new Eleicao("Estudantes", 18);
        candidato1 = new Candidato("Joana Almeida", 42, "Trofa");
        candidato2 = new Candidato("Ricardo Meireles", 50, "Maia");
        candidatoMenorIdade1 = new Candidato("Mariana Costa", 17, "Trofa");
        candidatoMenorIdade2 = new Candidato("Luís Pereira", 16, "Trofa");
        eleitor1 = new Eleitor("João Santos", "E001", 20, "joao@mail.com", "911000002");
        eleitor2 = new Eleitor("Inês Pires", "E007", 22, "ines@mail.com", "911000007");
        eleitorMenorIdade1 = new Eleitor("Filipa Sousa", "E009", 17, "filipa@mail.com", "911000009");
        eleitorMenorIdade2 = new Eleitor("Rita Faria", "E005", 16, "rita@mail.com", "911000005");


    }

    @Test
    void testAdicionarCandidatoValido() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        eleicoesAutarquicas.adicionarCandidato(candidato2);
        eleicoesEstudantes.adicionarCandidato(candidato1);
        eleicoesEstudantes.adicionarCandidato(candidato2);
        List<Candidato> lista1 = eleicoesAutarquicas.getCandidatos();
        List<Candidato> lista2 = eleicoesEstudantes.getCandidatos();
        assertTrue(lista1.contains(candidato1));
        assertTrue(lista1.contains(candidato2));
        assertTrue(lista2.contains(candidato1));
        assertTrue(lista2.contains(candidato2));
        assertEquals(2, lista1.size());
        assertEquals(2, lista2.size());
    }

    @Test
    void testAdicionarCandidatoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
        eleicoesAutarquicas.adicionarCandidato(candidatoMenorIdade1));
        assertThrows(IllegalArgumentException.class, () ->
        eleicoesAutarquicas.adicionarCandidato(candidatoMenorIdade2));
        assertThrows(IllegalArgumentException.class, () ->
        eleicoesEstudantes.adicionarCandidato(candidatoMenorIdade1));
        assertThrows(IllegalArgumentException.class, () ->
        eleicoesEstudantes.adicionarCandidato(candidatoMenorIdade2));
    }

    @Test
    void testEleitorValido() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        eleicoesAutarquicas.votar(eleitor1, candidato1);
        assertEquals(1, eleicoesAutarquicas.getVotos().size());
        assertEquals(1, eleicoesAutarquicas.contarVotos(candidato1));


    }

    @Test
    void testEleitorInvalido() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        assertThrows(IllegalArgumentException.class, () -> eleicoesAutarquicas.votar(eleitorMenorIdade1, candidato1));
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        assertThrows(IllegalArgumentException.class, () -> eleicoesAutarquicas.votar(eleitorMenorIdade2, candidato1));

    }

    @Test
    void testVotarApenasUmaVez() {
        eleicoesAutarquicas.adicionarCandidato(candidato2);
        eleicoesAutarquicas.votar(eleitor2, candidato2);
        assertThrows(IllegalArgumentException.class, () -> eleicoesAutarquicas.votar(eleitor2, candidato2));

    }

    @Test
    void testVotarCandidatoNaoRegistado() {
        assertThrows(IllegalArgumentException.class, () -> eleicoesAutarquicas.votar(eleitor1, candidato1));

    }

    @Test
    void testContarVotosPorCandidato() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        eleicoesAutarquicas.adicionarCandidato(candidato2);
        eleicoesAutarquicas.votar(eleitor1, candidato1);
        eleicoesAutarquicas.votar(eleitor2, candidato2);
        assertEquals(1, eleicoesAutarquicas.contarVotos(candidato1));
        assertEquals(1, eleicoesAutarquicas.contarVotos(candidato2));

    }

    @Test
    void testObterVencedor() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        eleicoesAutarquicas.adicionarCandidato(candidato2);
        eleicoesAutarquicas.votar(eleitor1, candidato1);
        eleicoesAutarquicas.votar(eleitor2, candidato1);
        assertEquals(candidato1, eleicoesAutarquicas.obterVencedor());
    }

    @Test
    void testEmpate() {
        eleicoesAutarquicas.adicionarCandidato(candidato1);
        eleicoesAutarquicas.adicionarCandidato(candidato2);
        eleicoesAutarquicas.votar(eleitor1, candidato1);
        eleicoesAutarquicas.votar(eleitor2, candidato2);
        assertEquals(null, eleicoesAutarquicas.obterVencedor());

    }


}