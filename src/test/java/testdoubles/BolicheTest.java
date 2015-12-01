package testdoubles;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BolicheTest {

    private Caixa caixa = new Caixa();

    @Before
    public void setUp() {
        caixa.adicionarCredito(1);
    }

    @Test
    public void credito_eh_consumido_se_ha_saldo_suficiente() {
        Boliche boliche = new Boliche();
        boliche.jogar(-999, 1, caixa);

        assertFalse(boliche.houveTentativaInvalida());
        assertEquals(0, caixa.saldo());
    }

    @Test
    public void credito_nao_eh_consumido_se_nao_ha_saldo_suficiente() {
        Boliche boliche = new Boliche();
        boliche.jogar(-999, 2, caixa);

        assertTrue(boliche.houveTentativaInvalida());
        assertEquals(1, caixa.saldo());
    }

    //// Adicionado depois ******************

    @Test
    public void email_eh_enviado_se_nao_ha_saldo_suficiente() {
        Boliche order = new Boliche();
        EmailServiceStub emailServiceStub = new EmailServiceStub();
        order.setMailer(emailServiceStub);
        order.jogar(-999, 2, caixa);
        assertEquals(1, emailServiceStub.quantidadeMensagensEnviadas());
    }

}