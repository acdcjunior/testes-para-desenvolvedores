package verificando;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PintorTest {

    @Test
    public void testarPintar() {
        // setup
        Pintor p = new Pintor();
        Casa casaMock = Mockito.mock(Casa.class);
        // execute
        p.pintar(casaMock);
        // verify
        verify(casaMock)
    }

}