package testdoubles;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class BolicheTestComMocks {

    @Test
    public void credito_eh_consumido_se_ha_saldo_suficiente() {
        // setup - dados
        Boliche boliche = new Boliche();
        Caixa caixaMock = mock(Caixa.class);
        // setup - expectativas
        when(caixaMock.temSaldo(1)).thenReturn(true);

        // execute
        boliche.jogar(-999, 1, caixaMock);

        // verify
        assertThat(boliche.houveTentativaInvalida(), is(false));
        verify(caixaMock).temSaldo(1);
        verify(caixaMock).consumirCredito(1);

        // teardown
        // implicito (garbage collector)
    }

    @Test
    public void credito_nao_eh_consumido_se_nao_ha_saldo_suficiente() {
        // given
        Boliche boliche = new Boliche();
        Caixa caixaMock = mock(Caixa.class);
        when(caixaMock.temSaldo(anyInt())).thenReturn(false);

        // when
        boliche.jogar(-999, 1, caixaMock);

        // then
        assertThat(boliche.houveTentativaInvalida(), is(true));
    }

    @Test
    public void email_eh_enviado_se_nao_ha_saldo_suficiente() {
        // given
        Boliche boliche = new Boliche();

        EmailService emailServiceMock = mock(EmailService.class);
        boliche.setMailer(emailServiceMock);

        Caixa caixaMock = mock(Caixa.class);
        when(caixaMock.temSaldo(anyInt())).thenReturn(false);
        // when
        boliche.jogar(-999, -888, caixaMock);
        // then
        verify(emailServiceMock).enviar(any(Mensagem.class));
    }

}