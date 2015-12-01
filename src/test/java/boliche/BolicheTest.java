package boliche;

import org.junit.Before;
import org.junit.Ignore;
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

    private void jogarSpare() {
        b.jogar(5);
        b.jogar(5);
    }

    private void jogarStrike() {
        b.jogar(10);
    }

    @Test
    public void bolaNaCanaletaJogoInteiro() {
        jogarVarias(20, 0);
        assertEquals(0, b.pontuacaoFinal());
    }

    @Test
    public void tudoUm() {
        jogarVarias(20, 1);
        assertEquals(20, b.pontuacaoFinal());
    }

    @Test
    public void umSpare() {
        jogarSpare();
        b.jogar(3);
        jogarVarias(17, 0);
        assertEquals(16, b.pontuacaoFinal());
    }

    @Test
    public void umStrike() {
        jogarStrike();
        b.jogar(3);
        b.jogar(4);
        jogarVarias(16, 0);
        assertEquals(24, b.pontuacaoFinal());
    }

    @Test
    public void jogoPerfeito() {
        jogarVarias(12, 10);
        assertEquals(300, b.pontuacaoFinal());
    }

}