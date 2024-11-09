import clases.EntradaUsuario;
import clases.Suma;

import java.util.List;

public class Main {

    private static final int SUMA = 1;
    private static final int RESTA = 2;
    private static final int MULTIPLICACION = 3;
    private static final int DIVISION = 4;
    private static final int SALIR = 5;

    public static void main(String[] args) {

        int opcion;
        boolean continuar;

        EntradaUsuario entradaUsuario = new EntradaUsuario();

        do {
            System.out.println("**** Aplicacion de Calculadora ****");
            System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);

            System.out.print("Por favor seleccione la operación a realizar : ");
            opcion = entradaUsuario.entradaInt();

            if(opcion >= 1 && opcion <=4){
                double resultado = 0;
                List<Double> operandos;

                switch (opcion){
                    case SUMA -> {
                        operandos = entradaUsuario.entradaOperandos();
                        resultado = Suma.sumar(operandos);

                        System.out.println("El resultado de sumar " + operandos + " es : " + resultado);
                    }
                    default -> {
                        System.out.println("Method not implemented");
                    }
                }
                continuar = entradaUsuario.entradaBooleana("¿Desea realizar otra operacion? ");
                if(!continuar) break;

            } else if (opcion == SALIR) {
                System.out.print("Hasta pronto...");
            }
            else{
                System.out.println("La opción " + opcion + " no es una opción válida");
            }
        } while (opcion != SALIR);
    }
}
