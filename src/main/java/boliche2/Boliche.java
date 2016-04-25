package boliche2;

public class Boliche {

    public static final int NUMERO_MAX_PINOS = 10;
    public static final int TOTAL_DE_FRAMES = 10;
    private int jogadas[] = new int[21];
    private int jogadaAtual = 0;


    public void jogar(int pinos) {
        jogadas[jogadaAtual++] = pinos;
    }

    public void pontuacaoFinal(Tela tela) {
        int pontuacao = 0;
        int primeiraJogadaDoFrame = 0;
        for (int frame = 0; frame < TOTAL_DE_FRAMES; frame++) {
            if (isStrike(primeiraJogadaDoFrame)) {
                pontuacao += NUMERO_MAX_PINOS + duasProximasJogadas(primeiraJogadaDoFrame);
                primeiraJogadaDoFrame++;
            } else if (isSpare(primeiraJogadaDoFrame)) {
                pontuacao += NUMERO_MAX_PINOS + proximaJogada(primeiraJogadaDoFrame);
                primeiraJogadaDoFrame += 2;
            } else {
                pontuacao += somaDasJogadasDoFrame(primeiraJogadaDoFrame);
                primeiraJogadaDoFrame += 2;
            }
        }
        tela.imprimir(pontuacao);
    }

    private int somaDasJogadasDoFrame(int primeiraJogadaDoFrame) {
        return jogadas[primeiraJogadaDoFrame] + jogadas[primeiraJogadaDoFrame + 1];
    }

    private int proximaJogada(int primeiraJogadaDoFrame) {
        return jogadas[primeiraJogadaDoFrame+2];
    }

    private int duasProximasJogadas(int primeiraJogadaDoFrame) {
        return jogadas[primeiraJogadaDoFrame + 1] + jogadas[primeiraJogadaDoFrame + 2];
    }

    private boolean isStrike(int primeiraJogadaDoFrame) {
        return jogadas[primeiraJogadaDoFrame] == NUMERO_MAX_PINOS;
    }

    private boolean isSpare(int primeiraJogadaDoFrame) {
        return jogadas[primeiraJogadaDoFrame] + jogadas[primeiraJogadaDoFrame+1] == NUMERO_MAX_PINOS;
    }

}
