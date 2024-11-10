package clases;

import java.util.List;

public class Suma {
    private Suma(){}

    /** Al ser un metodo estatico no se requiere instanciar la clase **/
    public static double sumar(List<Double> operandos){
        double resultado = 0;
        for(double operando : operandos){
            resultado+=operando;
        }
        return resultado;
    }
}
