package bolichesimplificado;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AprendendoMockito {

    @Test
    public void testeComVerify()  {
        // Configurar o mock
        MinhaClasse minhaClasseMock = mock(MinhaClasse.class);
        when(minhaClasseMock.getId()).thenReturn(43);

        // execute
        minhaClasseMock.testando(12);
        minhaClasseMock.getId();


        // verify

        // Agora verificamos se testando() foi chamado com o parâmetro 12
        verify(minhaClasseMock).testando(Matchers.eq(12));
        // verify(test).testando(Matchers.eq(11));

        // O método getId() foi chamado duas vezes?
        verify(minhaClasseMock, times(2)).getId();

        // Outros argumentos possíveis: times(5), never()
        //                              atLeastOnce(), atLeast(2), atMost(3)
    }


}