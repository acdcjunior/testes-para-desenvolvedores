package testdoubles;

import java.util.ArrayList;
import java.util.List;

public class EmailServiceStub implements EmailService {

    private List<Mensagem> mensagens = new ArrayList<>();

    public void enviar(Mensagem msg) {
        mensagens.add(msg);
    }

    public int quantidadeMensagensEnviadas() {
        return mensagens.size();
    }

}  