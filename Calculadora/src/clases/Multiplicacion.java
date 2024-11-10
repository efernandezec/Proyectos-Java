package clases;

import java.util.List;

public class Multiplicacion {
    private Multiplicacion(){}

    public static double multiplicar(List<Double> operandos){
        double resultado = 1;
        for(double operando: operandos){
            resultado*=operando;
        }
        return resultado;
    }
}
