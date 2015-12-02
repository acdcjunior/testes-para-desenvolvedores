package bolichesimplificado;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BolicheTest {

    private Boliche b;

    @Before
    public void setUp() {
        b = new Boliche();
    }

    private void jogarVarias(int n, int pinos) {
        for (int i = 0; i < n; i++) {
            b.jogar(pinos);
        }
    }

    private void assertPontuacao(int esperado) {
        assertEquals(esperado, b.pontuacaoFinal());
    }

    @Test
    public void bolaNaCanaletaJogoInteiro() {
        jogarVarias(20,  0);
        assertPontuacao(0);
    }

    @Test
    public void tudoUm() {
        jogarVarias(20, 1);
        assertPontuacao(20);
    }

    @Test
    public void jogoPerfeito() {
        jogarVarias(20, 10);
        assertPontuacao(200);
    }

}