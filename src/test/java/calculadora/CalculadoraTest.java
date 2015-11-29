package calculadora;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(10, 50);
        Assert.assertEquals(60, resultado);
    }

}