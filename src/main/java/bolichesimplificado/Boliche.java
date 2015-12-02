package bolichesimplificado;

public class Boliche {

    private int jogadas[] = new int[20];
    private int jogadaAtual = 0;

    public void jogar(int pinos) {
        jogadas[jogadaAtual++] = pinos;
    }

    public int pontuacaoFinal() {
        int pontuacao = 0;
        for (int jogada = 0; jogada < 20; jogada++) {
            pontuacao += jogadas[jogada];
        }
        return pontuacao;
    }

}