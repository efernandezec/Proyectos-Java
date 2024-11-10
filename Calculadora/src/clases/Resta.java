package clases;

import java.util.List;

public class Resta {
    private Resta(){}

    public static double restar(List<Double> operandos){
        double resultado=0;
        resultado = operandos.stream().reduce((a,b) -> a-b).orElse(0.0);
        return resultado;
    }

}
