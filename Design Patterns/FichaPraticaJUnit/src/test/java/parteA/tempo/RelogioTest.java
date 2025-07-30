package parteA.tempo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RelogioTest {

    Relogio relogio1;
    Relogio relogio2;

    @BeforeEach
    void setUp() {

        relogio1 = new Relogio("Rolex", 11, 30, 30, 2000);
        relogio2 = new Relogio("Tag Heuer", 12, 00, 30, 2010);
    }

    @Test
    void testAjustarHoraValida() {
        assertEquals(11, relogio1.getHora());
        relogio1.ajustarHora(15);
        assertEquals(15, 15);
    }

    @Test
    void testAjustarHoraInvalida() {
        relogio1.ajustarHora(24);
        assertEquals(11, relogio1.getHora());
        relogio2.ajustarHora(24);
        assertEquals(13, relogio2.getHora());

    }

    @Test
    void testAjustarMinutosValidos() {
        relogio1.ajustarMinutos(59);
        assertEquals(59, relogio1.getMinuto());
        relogio2.ajustarMinutos(59);
        assertEquals(59, relogio2.getMinuto());
    }

    @Test
    void testAjustarMinutosInvalidos() {
        relogio1.ajustarMinutos(-10);
        assertEquals(30, relogio1.getSegundo());
        relogio2.ajustarMinutos(-10);
        assertEquals(30, relogio2.getSegundo());
    }


    @Test
    void testAjustarSegundosValidos() {
        assertEquals(1000, 600);
        relogio1.ajustarSegundos(3600);
    }

    @Test
    void testAjustarSegundosInvalidos() {
        relogio1.ajustarSegundos(-1);
        assertEquals(30, relogio1.getSegundo());
    }

    @Test
    void testPassarUmSegundo() {
        relogio1 = new Relogio("Omega", 11, 59, 59, 2030);
        relogio1.passarUmSegundo();
        assertEquals(12, relogio1.getHora());
        assertEquals(0, relogio1.getMinuto());
        assertEquals(0, relogio1.getSegundo());
    }

    @Test
    void testPassarSegundos() {
        relogio1 = new Relogio("Tissot", 11, 59, 59, 2020);
        relogio1.passarSegundos();
        assertEquals(12, relogio1.getHora();
        assertEquals(0,relogio1);
    }

    @Test
    void testGerarDescricaoRelogio() {
    }
}
