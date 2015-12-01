package boliche;

public class Boliche {

    private int jogadas[] = new int[21];
    private int jogadaAtual = 0;

    public void jogar(int pinos) {
        jogadas[jogadaAtual++] = pinos;
    }

    public int pontuacaoFinal() {
        int pontuacao = 0;
        int primeiraNoFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(primeiraNoFrame)) {
                pontuacao += 10 + bonusDoStrike(primeiraNoFrame);
                primeiraNoFrame++;
            } else if (isSpare(primeiraNoFrame)) {
                pontuacao += 10 + bonusDoSpare(primeiraNoFrame);
                primeiraNoFrame += 2;
            } else {
                pontuacao += somaDasJogadasDoFrame(primeiraNoFrame);
                primeiraNoFrame += 2;
            }
        }
        return pontuacao;
    }

    private boolean isStrike(int primeiraNoFrame) {
        return jogadas[primeiraNoFrame] == 10;
    }

    private int bonusDoStrike(int primeiraNoFrame) {
        return jogadas[primeiraNoFrame + 1] + jogadas[primeiraNoFrame + 2];
    }

    private boolean isSpare(int primeiraNoFrame) {
        return jogadas[primeiraNoFrame] + jogadas[primeiraNoFrame+1] == 10;
    }

    private int bonusDoSpare(int primeiraNoFrame) {
        return jogadas[primeiraNoFrame + 2];
    }

    private int somaDasJogadasDoFrame(int primeiraNoFrame) {
        return jogadas[primeiraNoFrame] + jogadas[primeiraNoFrame + 1];
    }

}