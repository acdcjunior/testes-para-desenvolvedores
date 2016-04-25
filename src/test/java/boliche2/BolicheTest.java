package boliche2;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BolicheTest {

    private Boliche b;

    @Before
    public void setUp() throws Exception {
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
    public void tudoNaCanaleta() {
        jogarVarias(20, 0);
        assertPontuacao(0);
    }

    private void assertPontuacao(int pontuacaoEsperada) {
        TelaFalsa t = new TelaFalsa();
        b.pontuacaoFinal(t);
        assertEquals(pontuacaoEsperada, t.conteudoImpresso);
    }

    @Test
    public void tudoUm() {
        jogarVarias(20, 1);
        assertPontuacao(20);
    }

    @Test
    public void umSpare() {
        jogarSpare();
        b.jogar(3);
        jogarVarias(17 ,0);
        assertPontuacao(16);
    }

    @Test
    public void umStrike() {
        jogarStrike();
        b.jogar(3);
        b.jogar(4);
        jogarVarias(16, 0);
        assertPontuacao(24);
    }

    @Test
    public void jogoPerfeito() {
        jogarVarias(12, 10);
        assertPontuacao(300);
    }

    @Test
    public void strikeNoFinal() {
        jogarVarias(18, 0);
        jogarVarias(3, 10);
        assertPontuacao(30);
    }

}
