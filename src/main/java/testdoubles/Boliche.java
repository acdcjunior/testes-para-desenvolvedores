package testdoubles;

public class Boliche {

    private String produto;
    private int quantidade;

    private boolean tentativaInvalida = false;
    private EmailService mailer;

    public Boliche() {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setMailer(EmailService mailer) {
        this.mailer = mailer;
    }

    public void jogar(int pinos, int creditosNecessarios, Caixa caixa) {
        if (caixa.temSaldo(creditosNecessarios)) {
            caixa.consumirCredito(creditosNecessarios);
        } else {
            this.tentativaInvalida = true;
            enviarEmail();
        }
    }

    private void enviarEmail() {
        if (this.mailer != null) {
            this.mailer.enviar(new Mensagem());
        }
    }

    public boolean houveTentativaInvalida() {
        return tentativaInvalida;
    }

}