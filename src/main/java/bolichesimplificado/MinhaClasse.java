package bolichesimplificado;

public class MinhaClasse {

    public int getId() { return 1234567; }

    public String getNome() { return "Joao"; }

    public MorouOuNao jahMorou(MorouOuNao x) {
       return new MorouOuNao(false);

    }

    public void testando(int i) {

    }
}

class MorouOuNao {
    boolean morouOuNao;
    public MorouOuNao(boolean morouOuNao) {
        this.morouOuNao = morouOuNao;
    }
}