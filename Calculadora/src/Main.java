import clases.EntradaUsuario;
import clases.Suma;

public class Main {
    public static void main(String[] args) {
        System.out.println("**** Aplicacion de Calculadora ****");
        double operando1;
        double operando2;
        double resultado;

        EntradaUsuario entradaUsuario = new EntradaUsuario();
        operando1 = entradaUsuario.solicitarOperando();
        operando2 = entradaUsuario.solicitarOperando();
        resultado = Suma.sumar(operando1, operando2);

        System.out.print("El resultado de la suma de " + operando1 + " + " + operando2 + " es : " + resultado);
    }
}
