import clases.*;

import java.util.List;

public class Main {

    private static final int SUMA = 1;
    private static final int RESTA = 2;
    private static final int MULTIPLICACION = 3;
    private static final int DIVISION = 4;
    private static final int SALIR = 5;

    public static void main(String[] args) {

        int operacion;

        EntradaUsuario entradaUsuario = new EntradaUsuario();

        do {
            System.out.println("**** Aplicacion de Calculadora ****");
            mostrarMenu();

            System.out.print("Por favor seleccione la operación a realizar : ");
            operacion = entradaUsuario.entradaInt();

            if(operacion >= 1 && operacion <=4){
                List<Double> operandos;
                operandos = entradaUsuario.entradaOperandos();
                ejecutarOperacion(operacion, operandos);

                if(!entradaUsuario.entradaBooleana("¿Desea realizar otra operacion? ")){
                    System.out.println("Hasta pronto...");
                    break;
                }

            } else if (operacion == SALIR) {
                System.out.print("Hasta pronto...");
                break;
            }
            else{
                System.out.println("La operación " + operacion + " no es una opción válida");
            }
        } while (true);
    }
    private static void mostrarMenu(){
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
    }

    private static void ejecutarOperacion(int operacion, List<Double> operandos){
        double resultado;
        switch (operacion){
            case SUMA -> {
                resultado = Suma.sumar(operandos);
                System.out.println("El resultado de sumar " + operandos + " es : " + resultado);
            }
            case RESTA -> {
                resultado= Resta.restar(operandos);
                System.out.println("El resultado de restar " + operandos+ " es :" + resultado);
            }
            case MULTIPLICACION -> {
                resultado = Multiplicacion.multiplicar(operandos);
                System.out.println("El resultado de multiplicar " + operandos+ " es :" + resultado);
            }
            case DIVISION -> {
                resultado = Division.division(operandos);
                System.out.println("El resultado de dividir " + operandos+ " es :" + resultado);
            }
            default -> {
                System.out.println("Method not implemented");
            }
        }
    }
}
