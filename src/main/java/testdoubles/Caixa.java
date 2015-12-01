package testdoubles;

public class Caixa {

    private int creditos = 0;

    public void adicionarCredito(int quantidade) {
        creditos += quantidade;
    }

    public int saldo() {
        return creditos;
    }

    public void consumirCredito(int quantidade) {
        this.creditos -= quantidade;
    }

    public boolean temSaldo(int creditosNecessarios) {
        return creditos >= creditosNecessarios;
    }

}