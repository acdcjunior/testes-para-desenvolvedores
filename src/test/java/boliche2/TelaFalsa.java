package boliche2;

public class TelaFalsa extends Tela {

    public int conteudoImpresso;

    @Override
    public void imprimir(int conteudo) {
        this.conteudoImpresso = conteudo;
    }

}
