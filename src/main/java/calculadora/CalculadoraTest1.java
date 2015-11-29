package calculadora;

public class CalculadoraTest1 {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.somar(10, 50);
        
        System.out.println("Resultado: " + resultado);
    }

}