package bolichesimplificado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BolicheTest {

    private Boliche b;

    @Before
    public void setUp() {
        b = new Boliche();
    }

    @After
    public void tearDown() {
        // desfaria qualquer coisa
    }

    private void jogarVarias(int n, int pinos) {
        for (int i = 0; i < n; i++) {
            b.jogar(pinos);
        }
    }

    private void assertPontuacao(int esperado) {
        List<Integer> registroExterno = new ArrayList<>();
        b.pontuacaoFinal(registroExterno);

        int pontuacao = registroExterno.get(0);
        assertEquals(esperado, pontuacao);
    }

    @Test
    public void bolaNaCanaletaJogoInteiro() {
        // when
        jogarVarias(20,  0);
        // then
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