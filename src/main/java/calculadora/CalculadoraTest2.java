package calculadora;

public class CalculadoraTest2 {

    public int erros = 0;

    public void testSomar() throws Exception {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(10, 50);
        if (resultado != 60) {
            throw new Exception("Erro! Esperava 60, obtive " + resultado);
        }
    }

    public static void main(String[] args) {
        CalculadoraTest2 teste = new CalculadoraTest2();

        try {
            teste.testSomar();
        } catch (Exception e) {
            teste.erros++;
            System.out.println("- Razão da falha: " + e.getMessage());
        }

        if (teste.erros > 0) {
            System.out.println("Há " + teste.erros + " erro(s)!");
        }
    }

}