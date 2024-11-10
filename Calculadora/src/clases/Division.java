package clases;

import java.util.List;

public class Division {
    private Division(){}

    public static double division(List<Double> operandos){
        double resultado;
        resultado = operandos.stream().reduce((a,b) -> (a/b)).orElse(0.0);
        return resultado;
    }
}
